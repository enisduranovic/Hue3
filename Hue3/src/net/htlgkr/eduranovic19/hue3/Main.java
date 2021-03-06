package net.htlgkr.eduranovic19.hue3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Weapon> list = new LinkedList<>();
        try {
            list = Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                    s[0],
                    CombatType.valueOf(s[1]),
                    DamageType.valueOf(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6])
            ))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
//        list.sort((w1, w2) -> {
//            if(CombatType(w1).) {
//
//            }
//        }
        Printable p1 = (List<Weapon> weapon) -> {
            for (int i = 0; i < weapon.size(); i++) {
                System.out.println(weapon.get(i).toString());
            }
        };
        p1.print(list);

        Printable p2 = (List<Weapon> weapon) -> {
            for (int i = 0; i < weapon.size(); i++) {
                System.out.println(" ------------------------------------------------------------");
                System.out.println(" | " + weapon.get(i).getName() + " | " + weapon.get(i).getCombatType() + " | " + weapon.get(i).getDamageType() + " | " + weapon.get(i).getDamage() + " | " + weapon.get(i).getSpeed() + " | " + weapon.get(i).getMinStrength() + " | " + weapon.get(i).getValue() + " | ");
            }
            System.out.println(" ------------------------------------------------------------");
        };
        p2.print(list);

    }

}
