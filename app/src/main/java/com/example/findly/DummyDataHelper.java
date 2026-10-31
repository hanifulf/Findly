package com.example.findly;

import android.content.Context;
import java.util.List;

public class DummyDataHelper {

    public static void ensureDummy(Context ctx) {
        PlaceDatabase db = PlaceDatabase.getInstance(ctx);
        List<PlaceModel> all = db.placeDao().getAllPlaces();

        if (all != null && all.size() > 0) return;

        // ===============================
        // SERVICE AC (Lhokseumawe)
        // ===============================
        db.placeDao().insertPlace(new PlaceModel("Andi Service AC", "Service AC",
                5.1821, 97.1452, "Jl Merdeka, Banda Sakti",
                "08:00", "20:00", 4.8f, 50000));

        db.placeDao().insertPlace(new PlaceModel("Berkah AC Specialist", "Service AC",
                5.1850, 97.1523, "Jl Samudera, Cunda",
                "09:00", "21:00", 4.6f, 55000));

        db.placeDao().insertPlace(new PlaceModel("FixCool Teknik", "Service AC",
                5.1788, 97.1481, "Jl Kenari, Hagu Selatan",
                "07:00", "18:00", 4.7f, 60000));
        db.placeDao().insertPlace(new PlaceModel("PolarTech AC", "Service AC",
                5.1829, 97.1478, "Jl Pusara, Banda Sakti",
                "08:00", "20:00", 4.7f, 52000));

        db.placeDao().insertPlace(new PlaceModel("Sejuk Abadi", "Service AC",
                5.1841, 97.1492, "Jl Kakap, Cunda",
                "09:00", "21:00", 4.5f, 50000));

        db.placeDao().insertPlace(new PlaceModel("Udara Segar Teknik", "Service AC",
                5.1787, 97.1520, "Jl Hiu, Banda Sakti",
                "07:00", "18:00", 4.6f, 58000));

        db.placeDao().insertPlace(new PlaceModel("AcehCool Service", "Service AC",
                5.1803, 97.1559, "Jl Permai, Cunda",
                "08:00", "19:00", 4.8f, 60000));

        db.placeDao().insertPlace(new PlaceModel("Prima Cooling", "Service AC",
                5.1858, 97.1508, "Jl Sukon, Banda Sakti",
                "09:00", "22:00", 4.4f, 49000));

        db.placeDao().insertPlace(new PlaceModel("FreshAir Teknik", "Service AC",
                5.1816, 97.1463, "Jl Cemara, Hagu Barat",
                "08:00", "17:00", 4.5f, 53000));

        db.placeDao().insertPlace(new PlaceModel("DinginMax AC", "Service AC",
                5.1799, 97.1514, "Jl Dahlia, Banda Sakti",
                "07:30", "19:00", 4.7f, 62000));

        db.placeDao().insertPlace(new PlaceModel("EnergyCool AC", "Service AC",
                5.1768, 97.1480, "Jl Mawar, Hagu Selatan",
                "08:00", "20:00", 4.6f, 57000));

        db.placeDao().insertPlace(new PlaceModel("Teknik Mandiri AC", "Service AC",
                5.1834, 97.1537, "Jl Ketapang, Cunda",
                "09:00", "22:00", 4.8f, 65000));

        db.placeDao().insertPlace(new PlaceModel("BreezyFix AC", "Service AC",
                5.1820, 97.1451, "Jl Rajali, Banda Sakti",
                "08:00", "20:00", 4.5f, 55000));

        // ===============================
        // LISTRIK
        // ===============================
//        db.placeDao().insertPlace(new PlaceModel("Arus Prima Elektrik", "Listrik",
//                5.1847, 97.1516, "Jl Sirih, Cunda",
//                "09:00", "22:00", 4.6f, 42000));
//
//        db.placeDao().insertPlace(new PlaceModel("PowerLine Service", "Listrik",
//                5.1804, 97.1482, "Jl Melati, Banda Sakti",
//                "08:00", "20:00", 4.4f, 39000));
//
//        db.placeDao().insertPlace(new PlaceModel("MegaVolt Elektrik", "Listrik",
//                5.1793, 97.1548, "Jl Cendrawasih, Cunda",
//                "09:00", "21:00", 4.7f, 45000));
//
//        db.placeDao().insertPlace(new PlaceModel("Ampere Elektrik", "Listrik",
//                5.1769, 97.1491, "Jl Kenangan, Hagu Selatan",
//                "08:00", "18:00", 4.5f, 41000));
//
//        db.placeDao().insertPlace(new PlaceModel("Daya Maju Teknik", "Listrik",
//                5.1831, 97.1572, "Jl Kupula, Cunda",
//                "07:30", "19:30", 4.8f, 46000));
//
//        db.placeDao().insertPlace(new PlaceModel("Sakti Elektrik", "Listrik",
//                5.1823, 97.1459, "Jl Mawar, Banda Sakti",
//                "08:00", "20:00", 4.5f, 42000));
//
//        db.placeDao().insertPlace(new PlaceModel("Volt Master", "Listrik",
//                5.1852, 97.1526, "Jl Seroja, Cunda",
//                "09:00", "23:00", 4.7f, 47000));
//
//        db.placeDao().insertPlace(new PlaceModel("ElektronPro", "Listrik",
//                5.1778, 97.1467, "Jl Kenari, Hagu Barat",
//                "08:00", "21:00", 4.4f, 43000));
//
//        db.placeDao().insertPlace(new PlaceModel("Cahaya Mandiri", "Listrik",
//                5.1801, 97.1500, "Jl Melur, Banda Sakti",
//                "09:00", "22:00", 4.6f, 48000));
//
//        db.placeDao().insertPlace(new PlaceModel("Teknik Jaya", "Listrik",
//                5.1827, 97.1564, "Jl Belimbing, Cunda",
//                "08:00", "20:00", 4.5f, 40000));
//
//        db.placeDao().insertPlace(new PlaceModel("Jaya Elektrik", "Listrik",
//                5.1813, 97.1545, "Jl Elak, Cunda",
//                "09:00", "21:00", 4.5f, 40000));
//
//        db.placeDao().insertPlace(new PlaceModel("Sumber Listrik", "Listrik",
//                5.1782, 97.1470, "Jl Bukit, Banda Sakti",
//                "08:00", "20:00", 4.4f, 35000));
//
//        db.placeDao().insertPlace(new PlaceModel("TeknoPower", "Listrik",
//                5.1849, 97.1568, "Jl Listrik, Cunda",
//                "10:00", "22:00", 4.7f, 45000));
        db.placeDao().insertPlace(new PlaceModel("Rizky Laptop Service", "Service Laptop",
                5.1801, 97.1462, "Jl Merdeka, Banda Sakti",
                "09:00", "20:00", 4.7f, 45000));

        db.placeDao().insertPlace(new PlaceModel("Lhokseumawe Tech Repair", "Service Laptop",
                5.1825, 97.1441, "Jl Perdagangan, Banda Sakti",
                "08:30", "21:00", 4.6f, 50000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Notebook Care", "Service Laptop",
                5.1833, 97.1478, "Jl Sukaramai, Banda Sakti",
                "09:00", "18:00", 4.8f, 55000));

        db.placeDao().insertPlace(new PlaceModel("Laptop Klinik Lhokseumawe", "Service Laptop",
                5.1814, 97.1429, "Jl Teuku Umar, Banda Sakti",
                "08:00", "17:00", 4.5f, 40000));

        db.placeDao().insertPlace(new PlaceModel("FixLab Lhokseumawe", "Service Laptop",
                5.1850, 97.1433, "Jl Darussalam, Banda Sakti",
                "10:00", "20:00", 4.7f, 60000));

        db.placeDao().insertPlace(new PlaceModel("Digital Tech Service", "Service Laptop",
                5.1862, 97.1481, "Jl T. Hamzah Bendahara",
                "09:00", "19:00", 4.4f, 45000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Computer Repair", "Service Laptop",
                5.1876, 97.1409, "Jl T. Panglima Polem",
                "08:30", "17:30", 4.9f, 70000));

        db.placeDao().insertPlace(new PlaceModel("Laptop Pro Center", "Service Laptop",
                5.1798, 97.1501, "Jl Kenari, Banda Sakti",
                "09:00", "20:30", 4.6f, 50000));

        db.placeDao().insertPlace(new PlaceModel("Zona Komputer Lhokseumawe", "Service Laptop",
                5.1883, 97.1455, "Jl Merdeka Timur",
                "08:00", "18:00", 4.5f, 45000));

        db.placeDao().insertPlace(new PlaceModel("ReTech Service Center", "Service Laptop",
                5.1844, 97.1490, "Jl Perdagangan Lama",
                "09:30", "20:00", 4.7f, 55000));

        db.placeDao().insertPlace(new PlaceModel("GadgetFix Lhokseumawe", "Service Laptop",
                5.1830, 97.1513, "Jl Listrik, Banda Sakti",
                "10:00", "19:00", 4.6f, 50000));

        db.placeDao().insertPlace(new PlaceModel("LaptopCare Aceh", "Service Laptop",
                5.1891, 97.1472, "Jl Samudera, Banda Sakti",
                "08:00", "17:30", 4.8f, 65000));

        db.placeDao().insertPlace(new PlaceModel("Mitra Komputer Lhokseumawe", "Service Laptop",
                5.1855, 97.1520, "Jl Elak, Banda Sakti",
                "09:00", "20:00", 4.5f, 45000));

        db.placeDao().insertPlace(new PlaceModel("LaptopFix ID", "Service Laptop",
                5.1788, 97.1421, "Jl Mawar, Banda Sakti",
                "08:30", "18:30", 4.9f, 60000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Tech Support", "Service Laptop",
                5.1810, 97.1534, "Jl Cinta Kasih",
                "09:00", "21:00", 4.7f, 55000));

        db.placeDao().insertPlace(new PlaceModel("Service Center Lhokseumawe", "Service Laptop",
                5.1777, 97.1509, "Jl K.H. Ahmad Dahlan",
                "08:00", "18:00", 4.6f, 50000));

        db.placeDao().insertPlace(new PlaceModel("ProFix Notebook", "Service Laptop",
                5.1902, 97.1499, "Jl Darussalam Barat",
                "09:00", "19:00", 4.5f, 48000));

        db.placeDao().insertPlace(new PlaceModel("KomputerOne Lhokseumawe", "Service Laptop",
                5.1828, 97.1414, "Jl Blang Panyang",
                "10:00", "20:00", 4.7f, 55000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Gadget & Laptop Repair", "Service Laptop",
                5.1867, 97.1504, "Jl Tumpok Teungoh",
                "09:00", "18:00", 4.8f, 65000));

        db.placeDao().insertPlace(new PlaceModel("Laptop Service Specialist", "Service Laptop",
                5.1807, 97.1486, "Jl Pase, Banda Sakti",
                "08:30", "20:00", 4.6f, 50000));

        // ===============================
        // CLEANING
        // ===============================
        db.placeDao().insertPlace(new PlaceModel("Kedai Kopi Lhokseumawe", "Food & Drink",
                5.18811, 97.14251, "Jl Merdeka, Banda Sakti",
                "08:00", "23:00", 4.7f, 15000));

        db.placeDao().insertPlace(new PlaceModel("Ayam Lepas Cunda", "Food & Drink",
                5.18650, 97.12590, "Jl Medan-Banda Aceh, Cunda",
                "10:00", "22:00", 4.5f, 25000));

        db.placeDao().insertPlace(new PlaceModel("Bakso UTE", "Food & Drink",
                5.19422, 97.13077, "Jl Kampus UTE, Blang Pulo",
                "09:00", "21:00", 4.4f, 18000));

        db.placeDao().insertPlace(new PlaceModel("Mie Aceh Murni", "Food & Drink",
                5.18940, 97.14180, "Jl Pase Batu, Banda Sakti",
                "11:00", "23:30", 4.6f, 23000));

        db.placeDao().insertPlace(new PlaceModel("Roti Bakar Cunda", "Food & Drink",
                5.18690, 97.12710, "Jl Elak Cunda",
                "16:00", "00:00", 4.3f, 12000));

        db.placeDao().insertPlace(new PlaceModel("Sate Matang Lhokseumawe", "Food & Drink",
                5.18777, 97.13940, "Jl Sukaramai, Banda Sakti",
                "17:00", "23:00", 4.8f, 30000));

        db.placeDao().insertPlace(new PlaceModel("Nasi Goreng Cunda", "Food & Drink",
                5.18511, 97.12833, "Jl Elak Cunda, Dekat Indomaret",
                "18:00", "02:00", 4.5f, 15000));

        db.placeDao().insertPlace(new PlaceModel("Es Teh Jumbo 77", "Food & Drink",
                5.19055, 97.14511, "Jl Samudera, Lhokseumawe",
                "13:00", "23:00", 4.2f, 8000));

        db.placeDao().insertPlace(new PlaceModel("Ayam Penyet Lestari", "Food & Drink",
                5.18880, 97.13690, "Jl Darussalam, Banda Sakti",
                "10:00", "21:30", 4.4f, 20000));

        db.placeDao().insertPlace(new PlaceModel("Kopi Warkop 88", "Food & Drink",
                5.18972, 97.13822, "Jl Pasee, Lhokseumawe",
                "07:00", "00:00", 4.7f, 10000));

        db.placeDao().insertPlace(new PlaceModel("Burger Cunda Town", "Food & Drink",
                5.18650, 97.12970, "Jl Elak Cunda",
                "15:00", "23:30", 4.3f, 22000));

        db.placeDao().insertPlace(new PlaceModel("Soto Lamongan Pak Heri", "Food & Drink",
                5.19110, 97.14700, "Jl Samudera, Banda Sakti",
                "08:00", "20:00", 4.5f, 18000));

        db.placeDao().insertPlace(new PlaceModel("Kebab Istanbul Cunda", "Food & Drink",
                5.18560, 97.12480, "Jl Medan-Banda Aceh, Cunda",
                "15:00", "23:00", 4.4f, 16000));

        db.placeDao().insertPlace(new PlaceModel("Boba Lhok Sweet", "Food & Drink",
                5.18740, 97.14080, "Jl Merdeka, Banda Sakti",
                "10:00", "22:00", 4.2f, 18000));

        db.placeDao().insertPlace(new PlaceModel("Seafood Rayeuk", "Food & Drink",
                5.19333, 97.15021, "Jl Samudera, Dekat Pantai Kiram",
                "17:00", "23:30", 4.6f, 40000));

        db.placeDao().insertPlace(new PlaceModel("Pisang Coklat Mantul", "Food & Drink",
                5.18701, 97.13770, "Jl T. Iskandar, Lhokseumawe",
                "14:00", "22:00", 4.1f, 10000));

        db.placeDao().insertPlace(new PlaceModel("Martabak Aceh Cunda", "Food & Drink",
                5.18680, 97.12650, "Jl Medan-Banda Aceh, Cunda",
                "18:00", "01:00", 4.5f, 20000));

        db.placeDao().insertPlace(new PlaceModel("Dimsum 99 Lhokseumawe", "Food & Drink",
                5.18899, 97.14270, "Jl Merdeka, Banda Sakti",
                "14:00", "22:00", 4.4f, 17000));

        db.placeDao().insertPlace(new PlaceModel("Teh Tarik Aceh Kuy", "Food & Drink",
                5.18951, 97.13999, "Jl Pasee, Banda Sakti",
                "08:00", "23:00", 4.6f, 9000));

        db.placeDao().insertPlace(new PlaceModel("Pizza Mini HomeMade", "Food & Drink",
                5.19240, 97.14690, "Jl Samudera, Banda Sakti",
                "13:00", "21:00", 4.3f, 25000));

        // ===============================
        // LAUNDRY
        // ===============================
        db.placeDao().insertPlace(new PlaceModel("Laundry Bersih", "Laundry",
                5.1793, 97.1497, "Jl Mawar, Banda Sakti",
                "07:00", "22:00", 4.3f, 25000));

        db.placeDao().insertPlace(new PlaceModel("Express Laundry", "Laundry",
                5.1837, 97.1551, "Jl Merpati, Cunda",
                "08:00", "23:00", 4.5f, 30000));

        db.placeDao().insertPlace(new PlaceModel("CleanWash Profesional", "Laundry",
                5.1768, 97.1438, "Jl Cendana, Hagu Selatan",
                "06:00", "20:00", 4.6f, 28000));
        db.placeDao().insertPlace(new PlaceModel("Wash & Go Laundry", "Laundry",
                5.1812, 97.1503, "Jl Anggrek, Banda Sakti",
                "07:00", "22:00", 4.6f, 26000));

        db.placeDao().insertPlace(new PlaceModel("Laundry Kilat", "Laundry",
                5.1838, 97.1542, "Jl Cempaka, Cunda",
                "08:00", "23:00", 4.5f, 30000));

        db.placeDao().insertPlace(new PlaceModel("FreshWash Center", "Laundry",
                5.1774, 97.1481, "Jl Bakau, Hagu Selatan",
                "06:00", "20:00", 4.7f, 28000));

        db.placeDao().insertPlace(new PlaceModel("ExpressWash", "Laundry",
                5.1807, 97.1561, "Jl Merpati, Banda Sakti",
                "07:00", "21:00", 4.4f, 27000));

        db.placeDao().insertPlace(new PlaceModel("Nauli Laundry", "Laundry",
                5.1849, 97.1520, "Jl Rambutan, Cunda",
                "08:00", "23:00", 4.8f, 32000));

        db.placeDao().insertPlace(new PlaceModel("CleanCore Laundry", "Laundry",
                5.1822, 97.1479, "Jl Mawar, Banda Sakti",
                "06:00", "19:00", 4.5f, 25000));

        db.placeDao().insertPlace(new PlaceModel("AcehWash Pro", "Laundry",
                5.1791, 97.1555, "Jl Kakap, Cunda",
                "07:00", "22:00", 4.6f, 29000));

        db.placeDao().insertPlace(new PlaceModel("Cunda Laundry Center", "Laundry",
                5.1768, 97.1505, "Jl Selada, Hagu Selatan",
                "06:00", "20:00", 4.4f, 24000));

        db.placeDao().insertPlace(new PlaceModel("SparkWash", "Laundry",
                5.1835, 97.1517, "Jl Cemara, Cunda",
                "08:00", "23:00", 4.7f, 31000));

        db.placeDao().insertPlace(new PlaceModel("WashPro Aceh", "Laundry",
                5.1802, 97.1490, "Jl Melur, Banda Sakti",
                "07:00", "22:00", 4.5f, 26000));

        // ===============================
        // TUKANG KUNCI
        // ===============================
        db.placeDao().insertPlace(new PlaceModel("Ahmad Tukang Kunci", "Tukang Kunci",
                5.1829, 97.1512, "Jl Rajawali, Cunda",
                "09:00", "22:00", 4.7f, 70000));

        db.placeDao().insertPlace(new PlaceModel("Kunci Aman", "Tukang Kunci",
                5.1797, 97.1489, "Jl Walet, Banda Sakti",
                "10:00", "20:00", 4.4f, 65000));

        db.placeDao().insertPlace(new PlaceModel("FastLock Service", "Tukang Kunci",
                5.1844, 97.1544, "Jl Gurame, Cunda",
                "08:00", "23:00", 4.8f, 75000));
        db.placeDao().insertPlace(new PlaceModel("MasterLock Aceh", "Tukang Kunci",
                5.1834, 97.1528, "Jl Landak, Cunda",
                "09:00", "22:00", 4.8f, 72000));

        db.placeDao().insertPlace(new PlaceModel("LockFix Pro", "Tukang Kunci",
                5.1811, 97.1484, "Jl Kutilang, Banda Sakti",
                "10:00", "20:00", 4.6f, 68000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Kunci Center", "Tukang Kunci",
                5.1783, 97.1519, "Jl Ketapang, Hagu Selatan",
                "09:00", "21:00", 4.7f, 75000));

        db.placeDao().insertPlace(new PlaceModel("Cunda KeyMaker", "Tukang Kunci",
                5.1853, 97.1509, "Jl Rajali, Cunda",
                "08:00", "23:00", 4.5f, 66000));

        db.placeDao().insertPlace(new PlaceModel("FastUnlock", "Tukang Kunci",
                5.1807, 97.1551, "Jl Burung, Banda Sakti",
                "10:00", "20:00", 4.4f, 64000));

        db.placeDao().insertPlace(new PlaceModel("LockPro Aceh", "Tukang Kunci",
                5.1828, 97.1471, "Jl Nuri, Banda Sakti",
                "09:00", "23:00", 4.8f, 73000));

        db.placeDao().insertPlace(new PlaceModel("KeyMaster Lhok", "Tukang Kunci",
                5.1776, 97.1507, "Jl Cempedak, Hagu Selatan",
                "08:00", "21:00", 4.6f, 70000));

        db.placeDao().insertPlace(new PlaceModel("SaktiLock", "Tukang Kunci",
                5.1839, 97.1539, "Jl Jeruk, Cunda",
                "09:00", "22:00", 4.7f, 76000));

        db.placeDao().insertPlace(new PlaceModel("Aceh Fast Key", "Tukang Kunci",
                5.1817, 97.1502, "Jl Teratai, Banda Sakti",
                "08:00", "23:00", 4.5f, 69000));

        db.placeDao().insertPlace(new PlaceModel("Lhok Key Service", "Tukang Kunci",
                5.1788, 97.1476, "Jl Merbuk, Hagu Barat Laut",
                "10:00", "20:00", 4.4f, 62000));

        // ===============================
        // MONTIR
        // ===============================
        db.placeDao().insertPlace(new PlaceModel("MotoFix Pro", "Bengkel",
                5.1837, 97.1511, "Jl Kaktus, Cunda",
                "08:00", "18:00", 4.8f, 95000));

        db.placeDao().insertPlace(new PlaceModel("Service Motor Hagu", "Bengkel",
                5.1819, 97.1488, "Jl Rambutan, Banda Sakti",
                "07:00", "22:00", 4.5f, 85000));

        db.placeDao().insertPlace(new PlaceModel("SpeedTech Garage", "Bengkel",
                5.1798, 97.1563, "Jl Teratai, Cunda",
                "09:00", "20:00", 4.7f, 90000));

        db.placeDao().insertPlace(new PlaceModel("GearHead Lhok", "Bengkel",
                5.1767, 97.1503, "Jl Pinang, Hagu Selatan",
                "08:00", "21:00", 4.4f, 87000));

        db.placeDao().insertPlace(new PlaceModel("AutoPro Aceh", "Bengkel",
                5.1825, 97.1555, "Jl Sirsak, Cunda",
                "09:00", "18:00", 4.6f, 92000));

        db.placeDao().insertPlace(new PlaceModel("Roda Jaya Motor", "Bengkel",
                5.1854, 97.1533, "Jl Jeruk, Banda Sakti",
                "07:30", "22:00", 4.5f, 88000));

        db.placeDao().insertPlace(new PlaceModel("TuneUp Center Cunda", "Bengkel",
                5.1830, 97.1491, "Jl Sawo, Cunda",
                "08:00", "18:00", 4.7f, 94000));

        db.placeDao().insertPlace(new PlaceModel("FixGear Service", "Bengkel",
                5.1789, 97.1472, "Jl Ketapang, Banda Sakti",
                "07:00", "20:00", 4.6f, 89000));

        db.placeDao().insertPlace(new PlaceModel("MotoMax Aceh", "Bengkel",
                5.1811, 97.1507, "Jl Rajawali, Banda Sakti",
                "09:00", "21:00", 4.8f, 98000));

        db.placeDao().insertPlace(new PlaceModel("SpeedLine Garage", "Bengkel",
                5.1802, 97.1486, "Jl Elang, Banda Sakti",
                "08:00", "20:00", 4.5f, 90000));

        db.placeDao().insertPlace(new PlaceModel("Montir Mobil Pak Joko", "Bengkel",
                5.1867, 97.1571, "Jl Karet, Cunda",
                "08:00", "18:00", 4.6f, 90000));

        db.placeDao().insertPlace(new PlaceModel("Bengkel Motor Maju", "Bengkel",
                5.1784, 97.1455, "Jl Kuda, Hagu Selatan",
                "07:00", "22:00", 4.4f, 85000));

        db.placeDao().insertPlace(new PlaceModel("GearFix Garage", "Bengkel",
                5.1810, 97.1528, "Jl Beringin, Banda Sakti",
                "09:00", "20:00", 4.7f, 95000));
    }
}
