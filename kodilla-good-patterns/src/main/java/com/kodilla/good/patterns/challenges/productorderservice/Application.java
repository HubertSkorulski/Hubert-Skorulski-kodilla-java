package com.kodilla.good.patterns.challenges.productorderservice;

public class Application {
    public static void main(String[] args) {

        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new SMSInformationService(),new BookPurchaseService(),
                new BookPurchaseRepository(purchaseRequest.getUser(),purchaseRequest.getProductName(),purchaseRequest.getPrice()));

        productOrderService.process(purchaseRequest);

    }
}
