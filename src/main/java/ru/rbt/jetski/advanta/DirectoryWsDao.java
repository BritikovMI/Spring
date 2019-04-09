package ru.rbt.jetski.advanta;

import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiservice.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by BritikovMI on 25.02.2019.
 */
public class DirectoryWsDao {

    /* Справочник по таймшитам - Fields
        FieldID -- 0e63ef1b-aa39-4fd9-819b-ab1c19a323d6 : Вид деятельности :  : 6146ea12-7a5a-4af1-94f5-877b587a80d0 //Разработка ПО
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417ac : Дата :  : 2019-01-28 00:00:00Z
        FieldId -- 4112835b-c1b4-4176-a72a-678daa49df66 : Краткое описание задачи : Тестовое описание
        FieldID -- b2787e51-5886-47d0-b57d-ca31723818b7 : Продукт : Тест проодукт
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417a1 : Ресурс :  : Бритиков Максим Игоревич
        FieldID -- b6977f0a-bf32-4946-af71-0865219ec846 : Сверхурочные : 1
        FieldID -- caaaaaac-8920-4ab0-a553-b4516a8417aa : Статус :  : На редактировании
        FieldID -- b6977f0a-bf32-4946-af71-0865219ec846 : Сверхурочные :  : 0
        FieldID -- 06ff935a-c7fc-4ab3-8ad7-9012927cc651 : Фактические трудозатраты :  : 4
       Справочник по таймшитам - Fields */

    public static final String TYPE_OF_ACTIVITY_FLD_ID = "0e63ef1b-aa39-4fd9-819b-ab1c19a323d6";

    public static final String TYPE_OF_ACTIVITY_DEVELOPMENT_FLD_ID = "6146ea12-7a5a-4af1-94f5-877b587a80d0";

    public static final String DATE_FLD_ID = "caaaaaac-8920-4ab0-a553-b4516a8417ac";

    public static final String DESCRIPTION_FLD_ID = "4112835b-c1b4-4176-a72a-678daa49df66";

    public static final String PRODUCT_FLD_ID = "b2787e51-5886-47d0-b57d-ca31723818b7";

    public static final String RESOURCE_FLD_ID = "caaaaaac-8920-4ab0-a553-b4516a8417a1";

    public static final String STATUS_FLD_ID = "caaaaaac-8920-4ab0-a553-b4516a8417aa";

    public static final String OVERFACT_HOURS_FLD_ID = "b6977f0a-bf32-4946-af71-0865219ec846";

    public static final String FACT_HOURS_FLD_ID = "06ff935a-c7fc-4ab3-8ad7-9012927cc651";


    public String insertField(String sessionId, String directoryId, String projectId, String comment,  LocalDate localDate, String resource, String factHours) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String taskEndDate = dtf.format(localDate);
        System.out.println();

        FieldWrapper date = new FieldWrapper();
        date.setFieldId(DATE_FLD_ID);
        date.setFieldVal(taskEndDate + " 00:00:00Z");

        FieldWrapper description = new FieldWrapper();
        date.setFieldId(DESCRIPTION_FLD_ID);
        date.setFieldVal(comment);

        FieldWrapper employee = new FieldWrapper();
        employee.setFieldId(RESOURCE_FLD_ID);
        employee.setFieldVal(resource);

        FieldWrapper hours = new FieldWrapper();
        hours.setFieldId(FACT_HOURS_FLD_ID);
        hours.setFieldVal(factHours);

        ArrayOfFieldWrapper arw = new ArrayOfFieldWrapper();
        arw.getFieldWrapper().add(date);
        arw.getFieldWrapper().add(description);
        arw.getFieldWrapper().add(employee);
        arw.getFieldWrapper().add(hours);

        RecordWrapper rw = new RecordWrapper();
        rw.setFields(arw);

        APIService service = new APIService();
        APIServiceSoap apiServicesSoap = service.getAPIServiceSoap12();
        String newDirectoryCode = apiServicesSoap.insertDirectoryRecord(sessionId, directoryId, projectId, arw, rw);
        return newDirectoryCode;
    }

    public void getDirectory(String sessionId, String directoryId, String projecTId) {
        APIService service = new APIService();
        APIServiceSoap apiServicesSoap = service.getAPIServiceSoap12();
        RecordsListWrapper af = apiServicesSoap.getRecords(sessionId, directoryId, projecTId);
        af.getRecords().getRecordWrapper().forEach(fw -> {
                    fw.getFields().getFieldWrapper().forEach(rw -> {
                        if("Вид деятельности".equalsIgnoreCase(rw.getFieldName()))
                        System.out.println(rw.getFieldId() + " : " + rw.getFieldName() + " : " + rw.getFieldVal());
                    });
                });
//        GetDirectoryInfo gdi = new GetDirectoryInfo();
//        gdi.getDirectoryTemplateId();

        /*.getDirectories().getDirectoryWrapper().forEach(fw -> {
            System.out.println(fw.getUID() + " : " + fw.getName());
        });*/



        /*.getRecords(sessionId, directoryId, projecTId);
        af.getRecords().getRecordWrapper().forEach(fw -> {
            fw.getFields().getFieldWrapper().forEach(rw -> {
                System.out.println(rw.getFieldName() + " : " + rw.getFieldVal() + " : " + rw.getFieldType());
            });
        });*/
    }

    public static void main(String[] args) {
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();
        String sessionId = null;
        try {
            sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        String projectId = "4826bdc1-41c1-4f94-b15b-096236618adc", directoryId = "977ff0ae-56f8-40ad-8919-8175788e38c8";

        DirectoryWsDao dw = new DirectoryWsDao();

        dw.getDirectory(sessionId, directoryId, projectId);
    }
}
