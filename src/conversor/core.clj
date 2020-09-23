(ns conversor.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as http-client])
  (:gen-class))

(def program-options [["-f" "--from coin from"] ["-t" "--to coin to"]])

(def apiKey "5a90e48669a83c0e96fa")

(def apiUrl "https://free.currconv.com/api/v7/convert")

(defn parse-argument-to-query 
  [from to]
  (str from "_" to))


(defn -main
  [& args]
  (let [ {:keys [from to]} (:options (parse-opts args program-options)) ]
  (println (http-client/get apiUrl {:query-params { "q" (parse-argument-to-query from to) 
                                            "apiKey" apiKey }})))
