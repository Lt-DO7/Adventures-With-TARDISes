package net.awt.amblekit.ait.flight;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleAWTFlightHazard implements AWTFlightHazardType {
    private final String id;
    private final Predicate<AWTFlightHazardContext> triggerPredicate;
    private final Function<AWTFlightHazardContext, Float> chanceFunction;
    private final Function<AWTFlightHazardContext, Integer> durationFunction;
    private final Function<AWTFlightHazardContext, List<String>> controlsFunction;
    private final Consumer<AWTFlightHazardContext> successAction;
    private final Consumer<AWTFlightHazardContext> failureAction;

    public SimpleAWTFlightHazard(String id,
                                 Predicate<AWTFlightHazardContext> triggerPredicate,
                                 float chance,
                                 int durationTicks,
                                 List<String> requiredControls,
                                 Consumer<AWTFlightHazardContext> successAction,
                                 Consumer<AWTFlightHazardContext> failureAction) {
        this(id, triggerPredicate, context -> chance, context -> durationTicks, context -> requiredControls, successAction, failureAction);
    }

    public SimpleAWTFlightHazard(String id,
                                 Predicate<AWTFlightHazardContext> triggerPredicate,
                                 Function<AWTFlightHazardContext, Float> chanceFunction,
                                 Function<AWTFlightHazardContext, Integer> durationFunction,
                                 Function<AWTFlightHazardContext, List<String>> controlsFunction,
                                 Consumer<AWTFlightHazardContext> successAction,
                                 Consumer<AWTFlightHazardContext> failureAction) {
        this.id = id;
        this.triggerPredicate = triggerPredicate;
        this.chanceFunction = chanceFunction;
        this.durationFunction = durationFunction;
        this.controlsFunction = controlsFunction;
        this.successAction = successAction;
        this.failureAction = failureAction;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean canTrigger(AWTFlightHazardContext context) {
        return triggerPredicate.test(context);
    }

    @Override
    public float chance(AWTFlightHazardContext context) {
        return chanceFunction.apply(context);
    }

    @Override
    public int durationTicks(AWTFlightHazardContext context) {
        return durationFunction.apply(context);
    }

    @Override
    public List<String> requiredControls(AWTFlightHazardContext context) {
        return controlsFunction.apply(context);
    }

    @Override
    public void onSuccess(AWTFlightHazardContext context) {
        successAction.accept(context);
    }

    @Override
    public void onFailure(AWTFlightHazardContext context) {
        failureAction.accept(context);
    }
}
