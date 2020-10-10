(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as http])
  (:gen-class))

(def chave-api (System/getenv "CHAVE_API"))

(def api-url "https://free.currencyconverterapi.com/api/v6/convert")

(defn parametrizar-moedas 
  [de para]
  (str de "_" para))


(def opcoes-aceitaveis [
  ["-d", "--de moeda base", "moeda base para conversão"]
  ["-p", "--para moeda desejada", "moeda a qual queremos efetuar a conversão"]
])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Iniciando processamento...")
  (println "Temos" (count args) "argumentos.")
  (let [estrutura (parse-opts args opcoes-aceitaveis)
        {:keys [de para]} (:options estrutura)]
    (prn "Opções:"  (:options estrutura))
    (prn "Chave da api:" chave-api)))
