(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn- valores-em 
  [argumento]
  (cond 
    (.startsWith argumento "--de=")
      {:de (.substring argumento 5)}
    (.startsWith argumento "--para=")
      {:para (.substring argumento 7)}
    :else {}))

  (def opcoes-aceitaveis [
    ["-d", "--de moeda base", "moeda base para conversão"]
    ["-p", "--para moeda desejada", "moeda a qual queremos efetuar a conversão"]
  ])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Iniciando processamento...")
  (println "Temos" (count args) "argumentos.")
  (let [estrutura (parse-opts args opcoes-aceitaveis)]
    (println "Estrutura criada: " estrutura)
    (println "Opções: " (:options estrutura))))
