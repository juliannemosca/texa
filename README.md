# texa
A draft for how to make a text adventure game:

```
user=> (load-file "/path/to/texa.clj")
#'texa.core/g-readin
user=> (ns texa.core)
nil
texa.core=> room-0
#object[clojure.lang.Atom 0x32811494 {:status :ready, :val {:desc "it's a test room", :objects {:wine "it's a bottle of wine", :key "it's a golden key"}}}]
texa.core=> (g-readin)
take key
"you now have the key"
texa.core=> room-0
#object[clojure.lang.Atom 0x32811494 {:status :ready, :val {:desc "it's a test room", :objects {:wine "it's a bottle of wine"}}}]
texa.core=> (g-readin)
take wine
"you now have the wine"
texa.core=> room-0
#object[clojure.lang.Atom 0x32811494 {:status :ready, :val {:desc "it's a test room", :objects {}}}]
texa.core=> (g-readin)
take key
"can't take that"
```