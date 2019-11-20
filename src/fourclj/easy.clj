(ns fourclj.easy)

;; #19 Last Element
;; Write a function which returns the last element in a sequence.
(defn f19
  [s]
  (if (empty? s)
    nil
    (nth s (dec (count s)))))


;; #20 Penultimate Element
;; Write a function which returns the second to last element from a sequence.
(defn f20
  [s]
  (-> s
      (butlast)
      (last)))


;; #21 Nth Element
;; Write a function which returns the Nth element from a sequence.

