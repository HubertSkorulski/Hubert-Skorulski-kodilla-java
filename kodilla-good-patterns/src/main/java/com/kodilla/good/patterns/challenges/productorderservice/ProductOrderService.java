package com.kodilla.good.patterns.challenges.productorderservice;

public class ProductOrderService {
    private final InformationService informationService;
    private final PurchaseService purchaseService;
    private final PurchaseRepository purchaseRepository;

    public ProductOrderService(InformationService informationService, PurchaseService purchaseService, PurchaseRepository purchaseRepository) {

        this.informationService = informationService;
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;

    }

    public PurchaseSummary process (PurchaseRequest purchaseRequest) {

        boolean isBought = purchaseService.purchase(purchaseRequest.getUser(),purchaseRequest.getProductName(),purchaseRequest.getPrice());

        if (isBought) {
            informationService.inform(purchaseRequest.getUser());
            purchaseRepository.createPurchase(purchaseRequest.getUser(),purchaseRequest.getProductName(),purchaseRequest.getPrice());
            purchaseService.inform(purchaseRequest.getUser());
            System.out.println("Purchase process successed");
            return new PurchaseSummary(purchaseRequest.getUser(), purchaseRequest.getProductName(), true);
        } else {
            System.out.println("Purchase process failed");
            return new PurchaseSummary(purchaseRequest.getUser(), purchaseRequest.getProductName(), false);
        }


    }

}
