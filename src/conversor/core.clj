(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def program-options [["-f" "--from coin from"] ["-t" "--to coin to"]])

(defn -main
  [& args]
  (:options (parse-opts args program-options)))
