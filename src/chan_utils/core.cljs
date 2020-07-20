
(ns chan-utils.core
  (:require [clojure.core.async :refer [go >! <! chan]] [cljs.spec.alpha :as s]))

(defn all-once [chan-f xs]
  (assert (fn? chan-f) "expected a function")
  (assert (sequential? xs) "expected a sequence")
  (go
   (loop [acc [], tasks (doall (map chan-f xs))]
     (if (empty? tasks) acc (recur (conj acc (<! (first tasks))) (rest tasks))))))

(comment s/fdef all-once :args (s/cat :f fn? :xs list?) :ret list?)
