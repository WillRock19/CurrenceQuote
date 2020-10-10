(ns conversor.cambialista
    (:require [cheshire.core :refer [parse-string]]
              [clj-http.client :as http]))


(def chave-api (System/getenv "CHAVE_API"))

(def api-url "https://free.currencyconverterapi.com/api/v6/convert")

(defn parametrizar-moedas 
    [de para]
    (str de "_" para))

(defn obter-cotacao [de para]
    (let [moedas-formato-api (parametrizar-moedas de para)]
        (-> (:body (http/get api-url {:query-params { "q" moedas-formato-api, "apiKey" chave-api }}))
            (parse-string)
            (get-in ["results" moedas-formato-api "val"]))))