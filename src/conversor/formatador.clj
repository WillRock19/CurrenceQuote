(ns conversor.formatador)

(defn arredondar
    "Round a double to the given precision (number of significant digits)"
    ([numero]
      (arredondar numero 2))
    ([numero precision]
    (let [factor (Math/pow 10 precision)]
      (/ (Math/round (* numero factor)) factor))))

(defn formatar-resposta [valor-cotacao moeda-original moeda-convertida]
    (str "1 " moeda-original " equivale a " (arredondar valor-cotacao) " em " moeda-convertida))