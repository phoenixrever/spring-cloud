package com.phoenixhell.springcloud.loadbalance.Impl;

import com.phoenixhell.springcloud.loadbalance.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements LoadBalancer {
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public final int getAndIncrement(int serverCount) {
        int current;
        int next;
        do {
            current = nextServerCyclicCounter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
//        System.out.println("********next:" + next);
        return next % serverCount;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int serverCount = serviceInstances.size();
        if (serviceInstances == null || serviceInstances.size() == 0) {
            log.warn("No up servers available from load balancer");
            return null;
        }
        int nextServerIndex = getAndIncrement(serverCount);

        return serviceInstances.get(nextServerIndex);
    }
}
