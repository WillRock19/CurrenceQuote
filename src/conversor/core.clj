(ns conversor.core
  (:require [conversor.cambialista :refer [obter-cotacao]]
            [conversor.formatador :refer [formatar-resposta]]
            [conversor.interpretador-param-entrada :refer [interpretar-parametros]])
  (:gen-class))

(defn -main
  "Imprime a cotação das moedas desejadas"
  [& args]
  (println "Iniciando processamento...")
  (println "Temos" (count args) "argumentos.")
  (let [{:keys [de para]} (interpretar-parametros args)]
    (-> (obter-cotacao de para)
        (formatar-resposta de para)
        (prn))))
