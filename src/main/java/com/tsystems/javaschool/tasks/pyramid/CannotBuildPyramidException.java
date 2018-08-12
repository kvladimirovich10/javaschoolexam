package com.tsystems.javaschool.tasks.pyramid;

public class CannotBuildPyramidException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Can not build a pyramid, try another set.";
    }
}
