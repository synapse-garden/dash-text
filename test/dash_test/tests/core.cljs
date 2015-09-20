(ns dash-test.tests.core
  (:require [dash.core :as dash-core]))

(def tests
  [{:should "retrieve a test map"
    :test-fn #(mapv (fn [v] (apply dash-core/fetch-updates! v)) %)
    :args [["http://localhost:3449/test/get-data" (atom{})]
           ["http://localhost:3449/test/get-data" (atom{:foo "bar"})]]
    :should-be [{:data "data" :user "mf" :pass "pw"}
                {:data "data" :user "mf" :pass "pw" :foo "bar"}]
    :raw-fn '(dash.core/fetch-updates!)}

   {:should "return false given 'nil' and 'false' and true given anything else"
    :test-fn #(mapv boolean %)
    :args [false nil 0 1 3.1415 "a"]
    :should-be [false false true true true true]
    :raw-fn '(dash.core/bool-check)}
   ])