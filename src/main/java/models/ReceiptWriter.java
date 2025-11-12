package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        String receipt = createFileName();
        File file = new File(receipt);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("Receipt: " + generateTimestamp());
            bufferedWriter.write(order.receiptStringBuilder());
//            for (Product product: order.getProducts()){
//                bufferedWriter.write(product.getReceipt());
//            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private static String generateTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");
        return now.format(dateTimeFormatter);
    }

    public static String createFileName(){
        String fileName = new String("src/main/resources/receipts/" + generateTimestamp() + ".txt");
        return fileName;
    }
}
