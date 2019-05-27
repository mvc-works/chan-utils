
(ns chan-utils.main
  (:require [chan-utils.core :refer [chan-once all-once]]
            [clojure.core.async :refer [go >! <! chan]]))

(defn task! []
  (println "run task")
  (go
   (let [data (<! (chan-once got (js/setTimeout (fn [] (got 1)) 4000)))]
     (println "data" data)))
  (go (let [ys (all-once (fn [x] (chan)) 1)] )))

(defn main! [] (println "Started.") (task!))

(defn reload! [] (.clear js/console) (println "Reloaded.") (task!))
