(ns accumulate)

(defn accumulate [func seq]
  (loop [{:keys [accu seq]} {:accu [] :seq seq}]
    (if (empty? seq) accu
        (recur {:accu (conj accu (func (first seq)))
                :seq (rest seq)}))))
