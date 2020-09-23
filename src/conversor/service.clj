(ns conversor.service 
    (:require 
        [clj-http.client :as http-client]
        [cheshire.core :refer :all]))

(def apiKey (System/getenv "API_KEY"))

(def apiUrl "https://free.currconv.com/api/v7/convert")

(defn parse-argument-to-query 
    [from to]
    (str from "_" to))

(defn get-quotation 
    [from to]
    (let [currencies (parse-argument-to-query from to)]
    (-> (:body (http-client/get apiUrl 
                                {:query-params 
                                    { "q" currencies 
                                        "apiKey" apiKey } }))
    (parse-string)
    (get-in ["results" currencies "val"]))))