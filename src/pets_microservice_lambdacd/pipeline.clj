(ns pets-microservice-lambdacd.pipeline
  (:use [lambdacd.steps.control-flow]
        [pets-microservice-lambdacd.steps])
  (:require
        [lambdacd.steps.manualtrigger :as manualtrigger]))

(def pipeline-def
  `(
    manualtrigger/wait-for-manual-trigger
    some-step-that-does-nothing
    (in-parallel
      some-step-that-echos-foo
      some-step-that-echos-bar)
    manualtrigger/wait-for-manual-trigger
    some-failing-step))
