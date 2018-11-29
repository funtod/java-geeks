package com.hillel.elementary.javageeks.examples.exceptions;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExecutorTest {

    private Executor executor = new Executor();

    @Test
    void shouldExecuteTask() {
        Task task = new Task() {
            @Override
            public Object run() {
                return "Hello";
            }
        };

        Object result = executor.execute(task, 3);

        assertThat(result).isEqualTo("Hello");
    }

    @Test
    void shouldFailAfterAllAttempts() {
        Task task = new Task() {
            @Override
            public Object run() {
                throw new UnsupportedOperationException();
            }
        };

        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                executor.execute(task, 3);
            }
        }).isInstanceOf(ExecutionException.class);
    }

    @Test
    void shouldReturnValueIfSucceededWithinAllowedAttempts() {
        Task task = new Task() {
            int counter = 0;
            @Override
            public Object run() {
                if (counter++ < 2) {
                    throw new UnsupportedOperationException();
                }
                return "Hello";
            }
        };

        Object result = executor.execute(task, 3);

        assertThat(result).isEqualTo("Hello");
    }
}