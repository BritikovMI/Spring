
package ru.rbt.jetski.advanta.ws.apiservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "APIServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface APIServiceSoap {


    /**
     * 
     * @param aspnetSessionId
     * @param directoryId
     * @param projectId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.RecordsListWrapper
     */
    @WebMethod(operationName = "GetRecords", action = "http://tempuri.org/GetRecords")
    @WebResult(name = "GetRecordsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetRecords", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetRecords")
    @ResponseWrapper(localName = "GetRecordsResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetRecordsResponse")
    public RecordsListWrapper getRecords(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryId", targetNamespace = "http://tempuri.org/")
                    String directoryId,
            @WebParam(name = "projectId", targetNamespace = "http://tempuri.org/")
                    String projectId);

    /**
     *
     * @param classifierId
     * @param aspnetSessionId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DirectoriesListWrapper
     */
    @WebMethod(operationName = "GetUsedObjectsByClassifier", action = "http://tempuri.org/GetUsedObjectsByClassifier")
    @WebResult(name = "GetUsedObjectsByClassifierResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetUsedObjectsByClassifier", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetUsedObjectsByClassifier")
    @ResponseWrapper(localName = "GetUsedObjectsByClassifierResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetUsedObjectsByClassifierResponse")
    public DirectoriesListWrapper getUsedObjectsByClassifier(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "classifierId", targetNamespace = "http://tempuri.org/")
                    String classifierId);

    /**
     *
     * @param classifierId
     * @param aspnetSessionId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DirectoriesListWrapper
     */
    @WebMethod(operationName = "GetUsedTemplatesForClassifier", action = "http://tempuri.org/GetUsedTemplatesForClassifier")
    @WebResult(name = "GetUsedTemplatesForClassifierResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetUsedTemplatesForClassifier", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetUsedTemplatesForClassifier")
    @ResponseWrapper(localName = "GetUsedTemplatesForClassifierResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetUsedTemplatesForClassifierResponse")
    public DirectoriesListWrapper getUsedTemplatesForClassifier(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "classifierId", targetNamespace = "http://tempuri.org/")
                    String classifierId);

    /**
     *
     * @param directoryGroupId
     * @param childDirectoryId
     * @param aspnetSessionId
     * @param parentdirectoryRecordId
     * @param projectId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.RecordsListWrapper
     */
    @WebMethod(operationName = "GetChildRecords", action = "http://tempuri.org/GetChildRecords")
    @WebResult(name = "GetChildRecordsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetChildRecords", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetChildRecords")
    @ResponseWrapper(localName = "GetChildRecordsResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetChildRecordsResponse")
    public RecordsListWrapper getChildRecords(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryGroupId", targetNamespace = "http://tempuri.org/")
                    String directoryGroupId,
            @WebParam(name = "parentdirectoryRecordId", targetNamespace = "http://tempuri.org/")
                    String parentdirectoryRecordId,
            @WebParam(name = "childDirectoryId", targetNamespace = "http://tempuri.org/")
                    String childDirectoryId,
            @WebParam(name = "projectId", targetNamespace = "http://tempuri.org/")
                    String projectId);

    /**
     *
     * @param aspnetSessionId
     * @param directoryTemplateId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DirectoryInfoWrapper
     */
    @WebMethod(operationName = "GetDirectoryInfo", action = "http://tempuri.org/GetDirectoryInfo")
    @WebResult(name = "GetDirectoryInfoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetDirectoryInfo", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoryInfo")
    @ResponseWrapper(localName = "GetDirectoryInfoResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoryInfoResponse")
    public DirectoryInfoWrapper getDirectoryInfo(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryTemplateId", targetNamespace = "http://tempuri.org/")
                    String directoryTemplateId);

    /**
     *
     * @param directoryRecordId
     * @param aspnetSessionId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DeleteDirectoryRecord", action = "http://tempuri.org/DeleteDirectoryRecord")
    @WebResult(name = "DeleteDirectoryRecordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "DeleteDirectoryRecord", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DeleteDirectoryRecord")
    @ResponseWrapper(localName = "DeleteDirectoryRecordResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DeleteDirectoryRecordResponse")
    public String deleteDirectoryRecord(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryRecordId", targetNamespace = "http://tempuri.org/")
                    String directoryRecordId);

    /**
     *
     * @param directoryRecordId
     * @param record
     * @param aspnetSessionId
     * @param lstParams
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ChangeDirectoryRecord", action = "http://tempuri.org/ChangeDirectoryRecord")
    @WebResult(name = "ChangeDirectoryRecordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ChangeDirectoryRecord", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ChangeDirectoryRecord")
    @ResponseWrapper(localName = "ChangeDirectoryRecordResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ChangeDirectoryRecordResponse")
    public String changeDirectoryRecord(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryRecordId", targetNamespace = "http://tempuri.org/")
                    String directoryRecordId,
            @WebParam(name = "lstParams", targetNamespace = "http://tempuri.org/")
                    ArrayOfFieldWrapper lstParams,
            @WebParam(name = "record", targetNamespace = "http://tempuri.org/")
                    RecordWrapper record);

    /**
     *
     * @param recordStatus
     * @param directoryRecordId
     * @param aspnetSessionId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ChangeDirectoryRecordStatus", action = "http://tempuri.org/ChangeDirectoryRecordStatus")
    @WebResult(name = "ChangeDirectoryRecordStatusResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ChangeDirectoryRecordStatus", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ChangeDirectoryRecordStatus")
    @ResponseWrapper(localName = "ChangeDirectoryRecordStatusResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ChangeDirectoryRecordStatusResponse")
    public String changeDirectoryRecordStatus(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryRecordId", targetNamespace = "http://tempuri.org/")
                    String directoryRecordId,
            @WebParam(name = "RecordStatus", targetNamespace = "http://tempuri.org/")
                    String recordStatus);

    /**
     *
     * @param recordStatus
     * @param aspnetSessionId
     * @param directoryId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ArrayOfProjectWrapper
     */
    @WebMethod(operationName = "SearchDirectoryRecordsByStatus", action = "http://tempuri.org/SearchDirectoryRecordsByStatus")
    @WebResult(name = "SearchDirectoryRecordsByStatusResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchDirectoryRecordsByStatus", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.SearchDirectoryRecordsByStatus")
    @ResponseWrapper(localName = "SearchDirectoryRecordsByStatusResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.SearchDirectoryRecordsByStatusResponse")
    public ArrayOfProjectWrapper searchDirectoryRecordsByStatus(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryId", targetNamespace = "http://tempuri.org/")
                    String directoryId,
            @WebParam(name = "RecordStatus", targetNamespace = "http://tempuri.org/")
                    String recordStatus);

    /**
     *
     * @param aspnetSessionId
     * @param directoryId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DirectoryInfoWrapper
     */
    @WebMethod(operationName = "GetDirectoryRequisites", action = "http://tempuri.org/GetDirectoryRequisites")
    @WebResult(name = "GetDirectoryRequisitesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetDirectoryRequisites", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoryRequisites")
    @ResponseWrapper(localName = "GetDirectoryRequisitesResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoryRequisitesResponse")
    public DirectoryInfoWrapper getDirectoryRequisites(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryId", targetNamespace = "http://tempuri.org/")
                    String directoryId);

    /**
     *
     * @param record
     * @param aspnetSessionId
     * @param lstParams
     * @param directoryTemplateId
     * @param projectId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertDirectoryRecord", action = "http://tempuri.org/InsertDirectoryRecord")
    @WebResult(name = "InsertDirectoryRecordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "InsertDirectoryRecord", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertDirectoryRecord")
    @ResponseWrapper(localName = "InsertDirectoryRecordResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertDirectoryRecordResponse")
    public String insertDirectoryRecord(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryTemplateId", targetNamespace = "http://tempuri.org/")
                    String directoryTemplateId,
            @WebParam(name = "projectId", targetNamespace = "http://tempuri.org/")
                    String projectId,
            @WebParam(name = "lstParams", targetNamespace = "http://tempuri.org/")
                    ArrayOfFieldWrapper lstParams,
            @WebParam(name = "record", targetNamespace = "http://tempuri.org/")
                    RecordWrapper record);

    /**
     *
     * @param aspnetSessionId
     * @param type
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.DirectoriesListWrapper
     */
    @WebMethod(operationName = "GetDirectoriesList", action = "http://tempuri.org/GetDirectoriesList")
    @WebResult(name = "GetDirectoriesListResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetDirectoriesList", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoriesList")
    @ResponseWrapper(localName = "GetDirectoriesListResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDirectoriesListResponse")
    public DirectoriesListWrapper getDirectoriesList(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "type", targetNamespace = "http://tempuri.org/")
                    String type);

    /**
     *
     * @param classifierId
     * @param aspnetSessionId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.RecordsListWrapper
     */
    @WebMethod(operationName = "GetClassifierRecords", action = "http://tempuri.org/GetClassifierRecords")
    @WebResult(name = "GetClassifierRecordsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetClassifierRecords", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetClassifierRecords")
    @ResponseWrapper(localName = "GetClassifierRecordsResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetClassifierRecordsResponse")
    public RecordsListWrapper getClassifierRecords(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "classifierId", targetNamespace = "http://tempuri.org/")
                    String classifierId);

    /**
     *
     * @param classifierId
     * @param aspnetSessionId
     * @param name
     * @param lstParams
     * @param parentId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertClassifierRecord", action = "http://tempuri.org/InsertClassifierRecord")
    @WebResult(name = "InsertClassifierRecordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "InsertClassifierRecord", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertClassifierRecord")
    @ResponseWrapper(localName = "InsertClassifierRecordResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertClassifierRecordResponse")
    public String insertClassifierRecord(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "classifierId", targetNamespace = "http://tempuri.org/")
                    String classifierId,
            @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
                    String name,
            @WebParam(name = "parentId", targetNamespace = "http://tempuri.org/")
                    String parentId,
            @WebParam(name = "lstParams", targetNamespace = "http://tempuri.org/")
                    ArrayOfFieldWrapper lstParams);

    /**
     *
     * @param aspnetSessionId
     * @param directoryID
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.RelationObjectsListWrapper
     */
    @WebMethod(operationName = "GetRelationObjects", action = "http://tempuri.org/GetRelationObjects")
    @WebResult(name = "GetRelationObjectsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetRelationObjects", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetRelationObjects")
    @ResponseWrapper(localName = "GetRelationObjectsResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetRelationObjectsResponse")
    public RelationObjectsListWrapper getRelationObjects(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "DirectoryID", targetNamespace = "http://tempuri.org/")
                    String directoryID);

    /**
     *
     * @param aspnetSessionId
     * @param projectId
     * @param relationTemplateID
     * @param directoryRecordObjectID
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertObjectToProjectRelation", action = "http://tempuri.org/InsertObjectToProjectRelation")
    @WebResult(name = "InsertObjectToProjectRelationResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "InsertObjectToProjectRelation", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertObjectToProjectRelation")
    @ResponseWrapper(localName = "InsertObjectToProjectRelationResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.InsertObjectToProjectRelationResponse")
    public String insertObjectToProjectRelation(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryRecordObjectID", targetNamespace = "http://tempuri.org/")
                    String directoryRecordObjectID,
            @WebParam(name = "projectId", targetNamespace = "http://tempuri.org/")
                    String projectId,
            @WebParam(name = "relationTemplateID", targetNamespace = "http://tempuri.org/")
                    String relationTemplateID);

    /**
     *
     * @param aspnetSessionId
     * @param directoryId
     * @param fieldValue
     * @param fieldId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ArrayOfProjectWrapper
     */
    @WebMethod(operationName = "SearchDirectoryRecordValues", action = "http://tempuri.org/SearchDirectoryRecordValues")
    @WebResult(name = "SearchDirectoryRecordValuesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SearchDirectoryRecordValues", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.SearchDirectoryRecordValues")
    @ResponseWrapper(localName = "SearchDirectoryRecordValuesResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.SearchDirectoryRecordValuesResponse")
    public ArrayOfProjectWrapper searchDirectoryRecordValues(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "directoryId", targetNamespace = "http://tempuri.org/")
                    String directoryId,
            @WebParam(name = "fieldId", targetNamespace = "http://tempuri.org/")
                    String fieldId,
            @WebParam(name = "fieldValue", targetNamespace = "http://tempuri.org/")
                    String fieldValue);

    /**
     *
     * @param aspnetSessionId
     * @param documentId
     * @return
     *     returns ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.ArrayOfDocumentVersionWrapper
     */
    @WebMethod(operationName = "GetDocumentVersions", action = "http://tempuri.org/GetDocumentVersions")
    @WebResult(name = "GetDocumentVersionsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetDocumentVersions", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDocumentVersions")
    @ResponseWrapper(localName = "GetDocumentVersionsResponse", targetNamespace = "http://tempuri.org/", className = "ru.rbt.ru.rbt.jetski.advanta.ws.apiservice.GetDocumentVersionsResponse")
    public ArrayOfDocumentVersionWrapper getDocumentVersions(
            @WebParam(name = "ASPNETSessionId", targetNamespace = "http://tempuri.org/")
                    String aspnetSessionId,
            @WebParam(name = "documentId", targetNamespace = "http://tempuri.org/")
                    String documentId);

}