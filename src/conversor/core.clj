(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [cheshire.core :refer [parse-string]]
            [clj-http.client :as http])
  (:gen-class))

(def chave-api (System/getenv "CHAVE_API")) ;;3fa0891ce6d544690e06

(def api-url "https://free.currencyconverterapi.com/api/v6/convert")

(defn parametrizar-moedas 
  [de para]
  (str de "_" para))


(def opcoes-aceitaveis [
  ["-d", "--de moeda base", "moeda base para conversão"]
  ["-p", "--para moeda desejada", "moeda a qual queremos efetuar a conversão"]
])


(defn obter-cotacao [de para]
  (let [moedas-formato-api (parametrizar-moedas de para)]
    (-> (:body (http/get api-url {:query-params { "q" moedas-formato-api, "apiKey" chave-api }}))
        (parse-string)
        (get-in ["results" moedas-formato-api "val"]))))

(defn formata-resposta [valor-cotacao moeda-original moeda-convertida]
  (str "1 " moeda-original " equivale a " valor-cotacao " em " moeda-convertida))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Iniciando processamento...")
  (println "Temos" (count args) "argumentos.")
  (let [estrutura (parse-opts args opcoes-aceitaveis)
        {:keys [de para]} (:options estrutura)]
    (prn "Opções:"  (:options estrutura))
    (-> (obter-cotacao de para)
        (formata-resposta de para)
        (prn))))
