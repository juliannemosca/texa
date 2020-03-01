(ns texa.core
  (:require [clojure.string :as cl-str]))


;; nothing
;;
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; room stuff
;;
(def room-0 (atom
             {:desc "it's a test room"
              :objects {:wine "it's a bottle of wine"
                        :key "it's a golden key"}}))

(defn take-from-room [room objkey objname]
  (do
    (reset! room-0
            (assoc-in @room-0 [:objects]
                      (dissoc (:objects @room-0) objkey)))
    (str "you now have the " objname)))


;; action handlers
;;
(defn handle-take [s]
  (let [objname (first s)
        objkey (keyword objname)]

    (if (objkey (:objects @room-0))
      (take-from-room room-0 objkey objname)
      "can't take that")))

(defn handle-look [s]
  (str (cl-str/join " " s) "--echoing"))


;; game read input
;;
(defn g-readin []
  (let [l (cl-str/split (read-line) #" ")
        verb (first l)
        r-phrase (rest l)]
    (condp = verb
      "look" (handle-look r-phrase)
      "take" (handle-take r-phrase)
      :else "nope")))
