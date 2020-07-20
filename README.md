
Chan utils
----

[![Clojars Project](https://img.shields.io/clojars/v/mvc-works/chan-utils.svg)](https://clojars.org/mvc-works/chan-utils)

```edn
[mvc-works/chan-utils "0.1.0"]
```

### Usage

* ~~`chan-once`~~ has been removed.

* `chan-utils.core/all-once` is a function gathering a list of channels, and return values in a list after all of them finished.

```clojure
(cumulo-util.async/all-once get-chan [1 2 3 4]) ; like Promise.all
```

### License

MIT
