package org.example.devoir_libre.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Transaction {
    private TransactionType type;
    private Date timeStamp;
    private String reference;
    private List<Compte> comptes = new ArrayList<>();

}

enum TransactionType {
    VIRINI,
    VIREST,
    VIRMULTA,
    VIRCHAC
}
