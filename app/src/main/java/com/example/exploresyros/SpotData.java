package com.example.exploresyros;

import android.content.Context;
import android.util.Log;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class SpotData {
// όλο το περιεχόμενο των καρτών
    // σύνδεσης spots με pins (spots=topics, pins=pois) σε περίπτωση που ένα spot έχει παραπάνω από ένα pin (το υλοποιήσαμε έτσι ώστε η σχέση να είναι 1:1)
    private static List<Spot> spots = new ArrayList<Spot>();
    private static List<Pin> pins = new ArrayList<Pin>();

    public SpotData(Context context) {
        createSpotsandPins(context);

        for (Spot spot : spots)
            Log.d("XX", spot.getName());
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public Spot getSpot(String spotName) {

        for (Spot spot : spots) {
            if (spot.getName().equals(spotName))
                return spot;
        }
        return null;
    }

    public List<Pin> getPinsForSpot(String spotName) {
        ArrayList<Pin> pinsForSpot = new ArrayList<Pin>();

        for (Pin pin : pins) {
            if (pin.getPinGroup().equals(spotName))
                pinsForSpot.add(pin);
        }
        return pinsForSpot;
    }

    private void createSpotsandPins(Context context) {
        int[] spotNamesIDs = new int[]{
                R.string.spotsname0,
                R.string.spotsname1,
                R.string.spotsname2,
                R.string.spotsname3,
                R.string.spotsname4,
                R.string.spotsname5,
                R.string.spotsname6,
                R.string.spotsname7,
                R.string.spotsname8,
                R.string.spotsname9,
                R.string.spotsname10,
                R.string.spotsname11,
                R.string.spotsname12,
                R.string.spotsname13,
                R.string.spotsname14,
                R.string.spotsname15,
                R.string.spotsname16,
                R.string.spotsname17
        };

        int[] spotImageIDs = new int[]{
                R.drawable.img_industrialmuseum,
                R.drawable.img_archeologicanmuseum,
                R.drawable.img_textilemuseum,
                R.drawable.img_vamvakaris,
                R.drawable.img_theaterapollon,
                R.drawable.img_ststephen,
                R.drawable.img_varvarousa,
                R.drawable.img_pakou,
                R.drawable.img_delphini,
                R.drawable.img_komitos,
                R.drawable.img_stnikolaos,
                R.drawable.img_anastasi,
                R.drawable.img_koimisi,
                R.drawable.img_sangeorges,
                R.drawable.img_pinakothiki,
                R.drawable.img_tsiropina,
                R.drawable.img_kiveli,
                R.drawable.img_aquarium
        };

        int[] spotDescriptionsIDs = new int[]{
                R.string.spotsdescription0,
                R.string.spotsdescription1,
                R.string.spotsdescription2,
                R.string.spotsdescription3,
                R.string.spotsdescription4,
                R.string.spotsdescription5,
                R.string.spotsdescription6,
                R.string.spotsdescription7,
                R.string.spotsdescription8,
                R.string.spotsdescription9,
                R.string.spotsdescription10,
                R.string.spotsdescription11,
                R.string.spotsdescription12,
                R.string.spotsdescription13,
                R.string.spotsdescription14,
                R.string.spotsdescription15,
                R.string.spotsdescription16,
                R.string.spotsdescription17
        };

        // spot0
        Spot s0 = new Spot(
                context.getResources().getString(spotNamesIDs[0]),
                1,
                spotImageIDs[0],
                spotDescriptionsIDs[0], // Use resource ID
                "spotsdescription0"
        );
        spots.add(s0);

        int resID = context.getResources().getIdentifier("spot0geopoint", "array", context.getPackageName());
        String[] PinGeoPointStringArray = context.getResources().getStringArray(resID);
        GeoPoint geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin00 = new Pin(s0.getName(),
                geoPoint,
                R.drawable.img_industrialmuseum);
        pins.add(pin00);

// spot1
        Spot s1 = new Spot(
                context.getResources().getString(spotNamesIDs[1]),
                1,
                spotImageIDs[1],
                spotDescriptionsIDs[1], // Use resource ID
                "spotsdescription1"
        );
        spots.add(s1);

        resID = context.getResources().getIdentifier("spot1geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin01 = new Pin(s1.getName(),
                geoPoint,
                R.drawable.img_archeologicanmuseum);
        pins.add(pin01);

// spot2
        Spot s2 = new Spot(
                context.getResources().getString(spotNamesIDs[2]),
                1,
                spotImageIDs[2],
                spotDescriptionsIDs[2], // Use resource ID
                "spotsdescription2"
        );
        spots.add(s2);

        resID = context.getResources().getIdentifier("spot2geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin02 = new Pin(s2.getName(),
                geoPoint,
                R.drawable.img_textilemuseum);
        pins.add(pin02);

// spot3
        Spot s3 = new Spot(
                context.getResources().getString(spotNamesIDs[3]),
                1,
                spotImageIDs[3],
                spotDescriptionsIDs[3], // Use resource ID
                "spotsdescription3"
        );
        spots.add(s3);

        resID = context.getResources().getIdentifier("spot3geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin03 = new Pin(s3.getName(),
                geoPoint,
                R.drawable.img_vamvakaris);
        pins.add(pin03);

// spot4
        Spot s4 = new Spot(
                context.getResources().getString(spotNamesIDs[4]),
                1,
                spotImageIDs[4],
                spotDescriptionsIDs[4], // Use resource ID
                "spotsdescription4"
        );
        spots.add(s4);

        resID = context.getResources().getIdentifier("spot4geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin04 = new Pin(s4.getName(),
                geoPoint,
                R.drawable.img_theaterapollon);
        pins.add(pin04);

// spot5
        Spot s5 = new Spot(
                context.getResources().getString(spotNamesIDs[5]),
                1,
                spotImageIDs[5],
                spotDescriptionsIDs[5], // Use resource ID
                "spotsdescription5"
        );
        spots.add(s5);

        resID = context.getResources().getIdentifier("spot5geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin05 = new Pin(s5.getName(),
                geoPoint,
                R.drawable.img_ststephen);
        pins.add(pin05);

// spot6
        Spot s6 = new Spot(
                context.getResources().getString(spotNamesIDs[6]),
                1,
                spotImageIDs[6],
                spotDescriptionsIDs[6], // Use resource ID
                "spotsdescription6"
        );
        spots.add(s6);

        resID = context.getResources().getIdentifier("spot6geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin06 = new Pin(s6.getName(),
                geoPoint,
                R.drawable.img_varvarousa);
        pins.add(pin06);

// spot7
        Spot s7 = new Spot(
                context.getResources().getString(spotNamesIDs[7]),
                1,
                spotImageIDs[7],
                spotDescriptionsIDs[7], // Use resource ID
                "spotsdescription7"
        );
        spots.add(s7);

        resID = context.getResources().getIdentifier("spot7geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin07 = new Pin(s7.getName(),
                geoPoint,
                R.drawable.img_pakou);
        pins.add(pin07);

// spot8
        Spot s8 = new Spot(
                context.getResources().getString(spotNamesIDs[8]),
                1,
                spotImageIDs[8],
                spotDescriptionsIDs[8], // Use resource ID
                "spotsdescription8"
        );
        spots.add(s8);

        resID = context.getResources().getIdentifier("spot8geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin08 = new Pin(s8.getName(),
                geoPoint,
                R.drawable.img_delphini);
        pins.add(pin08);

// spot9
        Spot s9 = new Spot(
                context.getResources().getString(spotNamesIDs[9]),
                1,
                spotImageIDs[9],
                spotDescriptionsIDs[9], // Use resource ID
                "spotsdescription9"
        );
        spots.add(s9);

        resID = context.getResources().getIdentifier("spot9geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin09 = new Pin(s9.getName(),
                geoPoint,
                R.drawable.img_komitos);
        pins.add(pin09);

// spot10
        Spot s10 = new Spot(
                context.getResources().getString(spotNamesIDs[10]),
                1,
                spotImageIDs[10],
                spotDescriptionsIDs[10], // Use resource ID
                "spotsdescription10"
        );
        spots.add(s10);

        resID = context.getResources().getIdentifier("spot10geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin10 = new Pin(s10.getName(),
                geoPoint,
                R.drawable.img_stnikolaos);
        pins.add(pin10);

        // spot11
        Spot s11 = new Spot(
                context.getResources().getString(spotNamesIDs[11]),
                1,
                spotImageIDs[11],
                spotDescriptionsIDs[11], // Use resource ID
                "spotsdescription11"
        );
        spots.add(s11);

        resID = context.getResources().getIdentifier("spot11geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin11 = new Pin(s11.getName(),
                geoPoint,
                R.drawable.img_anastasi);
        pins.add(pin11);

// spot12
        Spot s12 = new Spot(
                context.getResources().getString(spotNamesIDs[12]),
                1,
                spotImageIDs[12],
                spotDescriptionsIDs[12], // Use resource ID
                "spotsdescription12"
        );
        spots.add(s12);

        resID = context.getResources().getIdentifier("spot12geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin12 = new Pin(s12.getName(),
                geoPoint,
                R.drawable.img_koimisi);
        pins.add(pin12);

// spot13
        Spot s13 = new Spot(
                context.getResources().getString(spotNamesIDs[13]),
                1,
                spotImageIDs[13],
                spotDescriptionsIDs[13], // Use resource ID
                "spotsdescription13"
        );
        spots.add(s13);

        resID = context.getResources().getIdentifier("spot13geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin13 = new Pin(s13.getName(),
                geoPoint,
                R.drawable.img_sangeorges);
        pins.add(pin13);

// spot14
        Spot s14 = new Spot(
                context.getResources().getString(spotNamesIDs[14]),
                1,
                spotImageIDs[14],
                spotDescriptionsIDs[14], // Use resource ID
                "spotsdescription14"
        );
        spots.add(s14);

        resID = context.getResources().getIdentifier("spot14geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin14 = new Pin(s14.getName(),
                geoPoint,
                R.drawable.img_pinakothiki);
        pins.add(pin14);

// spot15
        Spot s15 = new Spot(
                context.getResources().getString(spotNamesIDs[15]),
                1,
                spotImageIDs[15],
                spotDescriptionsIDs[15], // Use resource ID
                "spotsdescription15"
        );
        spots.add(s15);

        resID = context.getResources().getIdentifier("spot15geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin15 = new Pin(s15.getName(),
                geoPoint,
                R.drawable.img_tsiropina);
        pins.add(pin15);

// spot16
        Spot s16 = new Spot(
                context.getResources().getString(spotNamesIDs[16]),
                1,
                spotImageIDs[16],
                spotDescriptionsIDs[16], // Use resource ID
                "spotsdescription16"
        );
        spots.add(s16);

        resID = context.getResources().getIdentifier("spot16geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin16 = new Pin(s16.getName(),
                geoPoint,
                R.drawable.img_kiveli);
        pins.add(pin16);

// spot17
        Spot s17 = new Spot(
                context.getResources().getString(spotNamesIDs[17]),
                1,
                spotImageIDs[17],
                spotDescriptionsIDs[17], // Use resource ID
                "spotsdescription17"
        );
        spots.add(s17);

        resID = context.getResources().getIdentifier("spot17geopoint",
                "array", context.getPackageName());
        PinGeoPointStringArray = context.getResources().getStringArray(resID);
        geoPoint = new GeoPoint(
                Double.valueOf(PinGeoPointStringArray[0]),
                Double.valueOf(PinGeoPointStringArray[1]));
        Pin pin17 = new Pin(s17.getName(),
                geoPoint,
                R.drawable.img_aquarium);
        pins.add(pin17);
    }
}
