package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;


import com.amazon.ata.deliveringonourpromise.deliverypromiseservice.DeliveryPromiseServiceClient;
import com.amazon.ata.deliveringonourpromise.serviceclientInterface.ServiceClient;
import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.deliverypromiseservice.service.DeliveryPromiseService;
import com.amazon.ata.orderfulfillmentservice.OrderFulfillmentService;
import com.amazon.ata.orderfulfillmentservice.OrderPromise;



public class OrderFulfillmentServiceClient implements ServiceClient {
    private OrderFulfillmentService ofsClient;
    private DeliveryPromiseService deliveryPromiseService;


    public OrderFulfillmentServiceClient(OrderFulfillmentService ofsClient, DeliveryPromiseService deliveryPromiseService){
        this.ofsClient = ofsClient;
        this.deliveryPromiseService = deliveryPromiseService;
    }

    public Promise getDeliveryPromiseByOrderItemId (String customerOrderId) {
        OrderPromise ofsPromise = ofsClient.getOrderPromise(customerOrderId);


        if (null == ofsPromise) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(ofsPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(ofsPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(ofsPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(ofsPromise.getPromiseEffectiveDate())
                .withIsActive(ofsPromise.isActive())
                .withPromiseProvidedBy(ofsPromise.getPromiseProvidedBy())
                .withAsin(ofsPromise.getAsin())
                .build();
    }
}