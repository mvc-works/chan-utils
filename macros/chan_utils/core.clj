
(ns chan-utils.core
 (:require [clojure.core.async :refer [go >! chan]]
           [clojure.spec.alpha :as s]))

(defmacro chan-once [cb-name & body]
  `(let [<result# (chan)
         ~cb-name (fn [~'x] (go (>! <result# ~'x)))]
    ~@body
    <result#))

(s/fdef chan-once
 :args (s/cat :cb symbol? :body (s/+ any?))
 :ret any?)
