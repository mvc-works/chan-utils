
(ns chan-utils.main
  (:require [chan-utils.core :refer [all-once]]
            [clojure.core.async :refer [go >! <! chan timeout]]))

(defn task! []
  (println "run task")
  (comment println (macroexpand-1 '(go (<! (timeout 2000)) 1)))
  (comment go (let [data (<! (go (<! (timeout 2000)) 1))] (println "data" data)))
  (go
   (let [ys (all-once (fn [x] (go (<! (timeout (* 1000 x))) x)) [1 2])] (println (<! ys)))))

(defn main! [] (println "Started.") (task!))

(defn reload! [] (.clear js/console) (println "Reloaded.") (task!))
