/*
 * Copyright 1999-2020 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.annotation;

import com.alibaba.csp.sentinel.EntryType;

import java.lang.annotation.*;

/**
 * The annotation indicates a definition of Sentinel resource.
 *
 * @author Eric Zhao
 * @author zhaoyuguang
 * @since 0.1.1
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
/**
 * QPS or thread count.
 */
public abstract int count() default 1;

     * Max queueing timeout in rate limiting.
     */
    public abstract int maxQueueingTimeMs() default -1;
    /**
    /**
     * Interval in seconds.
     */
    public abstract long intervalSec() default 1;
     * @return name of the block exception function, empty by default
    /**
     * Whether to enable degrade.
     */
    public abstract boolean enableDegrade() default false;
     * The {@code blockHandler} is located in the same class with the original method by default.
    /**
     * Degrade strategy.
     */
    public abstract int degradeStrategy() default DegradeStrategyConstant.DEGRADE_STRATEGY_EXCEPTION;
     * @return the class where the block handler exists, should not provide more than one classes
    /**
     * Time out in milliseconds.
     */
    public abstract long timeoutMs() default -1;
     * @return name of the fallback function, empty by default
    /**
     * Whether to enable entry poll.
     */
    public abstract boolean enableEntryPoll() default false;
     * The {@code defaultFallback} is used as the default universal fallback method.
    /**
     * Interval in milliseconds.
     */
    public abstract long pollIntervalMs() default 1000L;
     * @since 1.6.0
    /**
     * Write sentry file on degrade or not.
     */
    public abstract boolean writeSentryOnDegrade() default false;
     * The {@code fallback} is located in the same class with the original method by default.
     * However, if some methods share the same signature and intend to set the same fallback,
     * then users can set the class where the fallback function exists. Note that the shared fallback method
     * must be static.
     *
     * @return the class where the fallback method is located (only single class)
     * @since 1.6.0
     */
    Class<?>[] fallbackClass() default {};

    /**
     * @return the list of exception classes to trace, {@link Throwable} by default
     * @since 1.5.1
     */
    Class<? extends Throwable>[] exceptionsToTrace() default {Throwable.class};
    
    /**
     * Indicates the exceptions to be ignored. Note that {@code exceptionsToTrace} should
     * not appear with {@code exceptionsToIgnore} at the same time, or {@code exceptionsToIgnore}
     * will be of higher precedence.
     *
     * @return the list of exception classes to ignore, empty by default
     * @since 1.6.0
     */
    Class<? extends Throwable>[] exceptionsToIgnore() default {};
}


