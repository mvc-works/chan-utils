
(ns chan-utils.main
  (:require [chan-utils.core :refer [chan-once all-once]]
            [clojure.core.async :refer [go >! <! chan]]))

(defn task! []
  (println "run task")
  (comment println (macroexpand-1 '(chan-once got (js/setTimeout (fn [] (got 1)) 4000))))
  (go
   (let [data (<! (chan-once got (js/setTimeout (fn [] (got 1)) 4000)))]
     (println "data" data)))
  (comment go (let [ys (all-once (fn [x] (chan)) [1 2])] )))

(defn main! [] (println "Started.") (task!))

(defn reload! [] (.clear js/console) (println "Reloaded.") (task!))
