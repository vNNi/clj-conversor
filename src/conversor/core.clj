(ns conversor.core
  (:require 
    [conversor.program-options :refer [interpreter-options]]
    [conversor.service :refer [get-quotation]]
    [conversor.formatter :refer [formatter]]
    )
  (:gen-class))

(defn -main
  [& args]
  (let [ {:keys [from to]} (interpreter-options args)]
    (-> 
      (get-quotation from to)
      (formatter from to)
      (println))))
