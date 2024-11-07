package org.example.devoir_libre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private int idTransaction;
    @JsonBackReference
    private Compte sourceAccount;

    @JsonBackReference
    private Compte destinationAccount;

    private double amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;  // Jackson will automatically handle this date format

    private TransactionType type;

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", sourceAccount=" + sourceAccount.getNumCompte() +
                ", destinationAccount=" + destinationAccount.getNumCompte() +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

    public static String toJson(Compte compte) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(compte);
    }

}

enum TransactionType {
    VIRMULTA, // Same country, same bank
    VIREST,   // Same country, different bank
    VIRINI,   // Different country, same bank
    VIRCHAC   // Different country, different bank
}
