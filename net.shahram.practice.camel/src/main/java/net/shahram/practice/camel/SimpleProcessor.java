package net.shahram.practice.camel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
public class SimpleProcessor {

    ObjectMapper objectMapper = new ObjectMapper();

    public static final String UUID_PLACEHOLDER_REGEX = "%UUID%";
    public static final String SERIAL_NO_PLACEHOLDER_REGEX = "%SERIAL_NUMBER%";

    public String getData(String serialNo) {
        StringBuilder result = new StringBuilder("[\n ");
        int cnt = 0;
        for (String template : getAllData()) {
            if (cnt++ > 0) {
                result.append(",\n ");
            }
            result.append(transformTemplate(template, serialNo));
        }
        result.append("]");

        return result.toString();
    }

    private String transformTemplate(String template, String serialNo) {
        String result = template.replaceAll(UUID_PLACEHOLDER_REGEX, UUID.randomUUID().toString());
        result = result.replaceAll(SERIAL_NO_PLACEHOLDER_REGEX, serialNo);
        return result.trim();
    }

    public String[] getAllData() {
        return new String[] {
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/erasures\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": {}, \"OnlyOnChange\": true }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.LastEraseDate\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/summaries\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": { \"Setting\": \"Val.Mode\", \"Value\": \"CPAP\" }, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Mode\", \"Val.Duration\", \"Val.MaskOn\", \"Val.MaskOff\", \"Val.AHI\", \"Val.AI\", \"Val.HI\", \"Val.OAI\", \"Val.CAI\", \"Val.UAI\", \"Val.CSR\", \"Val.Leak.50\", \"Val.Leak.70\", \"Val.Leak.95\", \"Val.Leak.Max\", \"Val.Humidifier\", \"Val.HeatedTube\", \"Val.AmbHumidity\", \"Val.PatientHours\", \"Val.BlowPress.5\", \"Val.BlowPress.95\", \"Val.Flow.5\", \"Val.Flow.95\", \"Val.BlowFlow.50\", \"Val.HumTemp.50\", \"Val.HTubeTemp.50\", \"Val.HTubePow.50\", \"Val.HumPow.50\", \"Val.SpO2.50\", \"Val.SpO2.95\", \"Val.SpO2.Max\", \"Val.SpO2Thresh\", \"Val.SignalStrength\", \"Val.FlightMode\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/summaries\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": { \"Setting\": \"Val.Mode\", \"Value\": \"AutoSet\" }, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Mode\", \"Val.Duration\", \"Val.MaskOn\", \"Val.MaskOff\", \"Val.AHI\", \"Val.AI\", \"Val.HI\", \"Val.OAI\", \"Val.CAI\", \"Val.UAI\", \"Val.CSR\", \"Val.Leak.50\", \"Val.Leak.70\", \"Val.Leak.95\", \"Val.Leak.Max\", \"Val.TgtIPAP.50\", \"Val.TgtIPAP.95\", \"Val.TgtIPAP.Max\", \"Val.Humidifier\", \"Val.HeatedTube\", \"Val.AmbHumidity\", \"Val.PatientHours\", \"Val.BlowPress.5\", \"Val.BlowPress.95\", \"Val.Flow.5\", \"Val.Flow.95\", \"Val.BlowFlow.50\", \"Val.HumTemp.50\", \"Val.HTubeTemp.50\", \"Val.HTubePow.50\", \"Val.HumPow.50\", \"Val.SpO2.50\", \"Val.SpO2.95\", \"Val.SpO2.Max\", \"Val.SpO2Thresh\", \"Val.SignalStrength\", \"Val.FlightMode\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/summaries\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": { \"Setting\": \"Val.Duration\", \"Value\": 0 }, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Duration\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/settings\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": { \"Setting\": \"Val.Mode\", \"Value\": \"CPAP\" }, \"OnlyOnChange\": true }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Mode\", \"CPAP.Val.Press\", \"CPAP.Val.StartPress\", \"CPAP.Val.EPR.EPREnable\", \"CPAP.Val.EPR.EPRType\", \"CPAP.Val.EPR.Level\", \"CPAP.Val.Ramp.RampEnable\", \"CPAP.Val.Ramp.RampTime\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/settings\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": { \"Setting\": \"Val.Mode\", \"Value\": \"AutoSet\" }, \"OnlyOnChange\": true }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Mode\", \"AutoSet.Val.MinPress\", \"AutoSet.Val.MaxPress\", \"AutoSet.Val.StartPress\", \"AutoSet.Val.EPR.EPREnable\", \"AutoSet.Val.EPR.EPRType\", \"AutoSet.Val.EPR.Level\", \"AutoSet.Val.Ramp.RampEnable\", \"AutoSet.Val.Ramp.RampTime\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/settings\", \"Trigger\": { \"Collect\": [ \"RemoteMod\" ], \"Conditional\": { \"Setting\": \"Set.Mode\", \"Value\": \"CPAP\" }, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Set.Mode\", \"CPAP.Set.Press\", \"CPAP.Set.StartPress\", \"CPAP.Set.EPR.EPREnable\", \"CPAP.Set.EPR.EPRType\", \"CPAP.Set.EPR.Level\", \"CPAP.Set.Ramp.RampEnable\", \"CPAP.Set.Ramp.RampTime\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/therapy/settings\", \"Trigger\": { \"Collect\": [ \"RemoteMod\" ], \"Conditional\": { \"Setting\": \"Set.Mode\", \"Value\": \"AutoSet\" }, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Set.Mode\", \"AutoSet.Set.MinPress\", \"AutoSet.Set.MaxPress\", \"AutoSet.Set.StartPress\", \"AutoSet.Set.EPR.EPREnable\", \"AutoSet.Set.EPR.EPRType\", \"AutoSet.Set.EPR.Level\", \"AutoSet.Set.Ramp.RampEnable\", \"AutoSet.Set.Ramp.RampTime\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/climate/settings\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": {}, \"OnlyOnChange\": true }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.ClimateControl\", \"Val.HumEnable\", \"Val.HumLevel\", \"Val.TempEnable\", \"Val.Temp\", \"Val.Tube\", \"Val.Mask\", \"Val.SmartStart\", \"Val.PtAccess\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/climate/settings\", \"Trigger\": { \"Collect\": [ \"RemoteMod\" ], \"Conditional\": {}, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Set.ClimateControl\", \"Set.HumEnable\", \"Set.HumLevel\", \"Set.TempEnable\", \"Set.Temp\", \"Set.Tube\", \"Set.Mask\", \"Set.SmartStart\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/faults\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": {}, \"OnlyOnChange\": true }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Fault.Device\", \"Fault.Humidifier\", \"Fault.HeatedTube\" ] }"
            ,
            "{ \"FG.SerialNo\": \"%SERIAL_NUMBER%\", \"SubscriptionId\": \"%UUID%\", \"ServicePoint\": \"/api/v1/details\", \"Trigger\": { \"Collect\": [ \"HALO\" ], \"Conditional\": {}, \"OnlyOnChange\": false }, \"Schedule\": { \"StartDate\": null, \"EndDate\": null }, \"Data\": [ \"Val.Leak.1m\", \"Val.TgtIPAP.1m\", \"Val.RespiratoryEvent\" ] }"
        };
    }

    @Data
    class Order {
        final String id;
        final int[] numbers;
    }

    public void simplyPrint(Object param1, String param2) throws Exception {
        log.info("Processing message: [{}], [{}]", param1, param2);
    }

    public void process(Object param1, String param2) throws Exception {
        if (!(param1 instanceof String)) {
            throw new IllegalStateException("Not expecting " + param1.getClass());
        }
        log.debug("Processing message: [{}], [{}]", param1, param2);
        for (HashMap<String, Object> element : stringToListOfHashMapFiltered(param1.toString())) {
            log.info("Received Item: [{}]", element);
        }
    }

    public void processOne(Object param1, String param2) throws Exception {
        if (!(param1 instanceof String)) {
            throw new IllegalStateException("Not expecting " + param1.getClass());
        }
        log.debug("Processing message: [{}], [{}]", param1, param2);
        log.info("Received Single Item: [{}]", stringToHashMapFiltered(param1.toString()));
    }

    private List<HashMap<String, Object>> stringToListOfHashMapFiltered(String message) throws IOException {

        List<HashMap<String, Object>> result = objectMapper.readValue(message, new TypeReference<List<HashMap<String, Object>>>() {});
        return result;
    }

    private HashMap<String, Object> stringToHashMapFiltered(String message) throws IOException {

        HashMap<String, Object> result = objectMapper.readValue(message, new TypeReference<HashMap<String, Object>>() {});
        return result;
    }
}
