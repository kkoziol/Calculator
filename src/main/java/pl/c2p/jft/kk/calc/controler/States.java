package pl.c2p.jft.kk.calc.controler;

public enum States {
    FirstEmpty {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstEmpty(controller));
        }
    },
    FirstIntegral {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstIntegral(controller));
        }
    },
    FirstFractional {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstFractional(controller));
        }
    },
    FirstNegativeEmpty {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstNegativeEmpty(controller));
        }
    },
    FirstNegativeIntegral {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstNegativeIntegral(controller));
        }
    },
    FirstNegativeFractional {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateFirstNegativeFractional(controller));
        }
    },
    SecondEmpty {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondEmpty(controller));
        }
    },
    SecondIntegral {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondIntegral(controller));
        }
    },
    SecondFractional {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondFractional(controller));
        }
    },
    SecondNegativeEmpty {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondNegativeEmpty(controller));
        }
    },
    SecondNegativeIntegral {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondNegativeIntegral(controller));
        }
    },
    SecondNegativeFractional {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateSecondNegativeFractional(controller));
        }
    },
    Resoult {
        @Override
        public State getInstance(CalcController controller) {
            return controller.states.computeIfAbsent(this.name(), k -> new StateResoult(controller));
        }
    };


    public abstract State getInstance(CalcController controller);
}
