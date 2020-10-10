(ns conversor.interpretador-param-entrada
    (:require [clojure.tools.cli :refer [parse-opts]]))


(def opcoes-aceitaveis [
    ["-d", "--de moeda base", "moeda base para conversão"]
    ["-p", "--para moeda desejada", "moeda a qual queremos efetuar a conversão"]
])

(defn interpretar-parametros [parametros]
    (:options (parse-opts parametros opcoes-aceitaveis)))