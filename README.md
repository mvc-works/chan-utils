
Chan utils
----

[![Clojars Project](https://img.shields.io/clojars/v/mvc-works/chan-utils.svg)](https://clojars.org/mvc-works/chan-utils)

```edn
[mvc-works/chan-utils "0.1.0-a1"]
```

### Usage

* `chan-utils.core/chan-once` is a macro for creating a channel.

```clojure
(chan-once cb-name body)
```

`cb-name` is the new variable for callback. For example, use `got` as the name:

```clojure
(go
 (let [data (<! (chan-once got
                  (js/setTimeout
                    (fn [] (got 1)) 4000)))]
   (println "data" data)))
```

* `chan-utils.core/all-once` is a function gathering a list of channels, and return values in a list after all of them finished.

```clojure
(cumulo-util.async/all-once get-chan [1 2 3 4]) ; like Promise.all
```

### License

MIT
