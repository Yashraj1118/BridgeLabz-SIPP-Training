package com.bridgelabz;

public class ParcelTracker {
    static class StageNode {
        String stageName;
        StageNode next;

        StageNode(String stageName) {
            this.stageName = stageName;
        }
    }

    StageNode head = null;

    void initializeDefaultChain() {
        addStageAtEnd("Packed");
        addStageAtEnd("Shipped");
        addStageAtEnd("In Transit");
        addStageAtEnd("Delivered");
    }

    void addStageAtEnd(String stage) {
        StageNode node = new StageNode(stage);
        if (head == null) {
            head = node;
            return;
        }
        StageNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = node;
    }

    void addCheckpointAfter(String afterStage, String checkpointName) {
        StageNode temp = head;
        while (temp != null) {
            if (temp.stageName.equalsIgnoreCase(afterStage)) {
                StageNode node = new StageNode(checkpointName);
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage \"" + afterStage + "\" not found.");
    }

    void loseParcelAfter(String stage) {
        StageNode temp = head;
        while (temp != null) {
            if (temp.stageName.equalsIgnoreCase(stage)) {
                temp.next = null;
                System.out.println("Parcel lost after: " + stage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage \"" + stage + "\" not found.");
    }

    void trackParcel() {
        if (head == null) {
            System.out.println("No tracking data available.");
            return;
        }

        StageNode temp = head;
        System.out.println("Parcel Tracking Path:");
        while (temp != null) {
            System.out.println("→ " + temp.stageName);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.initializeDefaultChain();
        tracker.trackParcel();

        System.out.println("\nAdding custom checkpoint: 'At Local Hub' after 'In Transit'");
        tracker.addCheckpointAfter("In Transit", "At Local Hub");
        tracker.trackParcel();

        System.out.println("\nSimulating parcel lost after 'Shipped'");
        tracker.loseParcelAfter("Shipped");
        tracker.trackParcel();
    }
}