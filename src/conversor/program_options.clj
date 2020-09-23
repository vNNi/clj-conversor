(ns conversor.program-options
    (:require [clojure.tools.cli :refer [parse-opts]]))

(def program-options 
    [["-f" "--from coin from"] 
    ["-t" "--to coin to"]])

(defn interpreter-options
    [args] 
    (:options (parse-opts args program-options)))