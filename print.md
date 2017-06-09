名詞定義
========
* `DxReport` = `DiagnosticReport`
* `ImgStudy` = `ImagingStudy`
* `AccessionNo` = Accession Number
* `foo["WTF"] = QOO` 表示會存在一個 `foo`、其 `system` 是「WTF」、`value` 是「QOO」


DxReport / ImgStudy
===================

|              |            DxReport            |        ImgStudy       |
|:------------:|:------------------------------:|:---------------------:|
| Organization |            performer           |    accession.system   |
|      Patient |             subject            |        patient        |
|     Modality |     identifier["modality"]     |    series/modality    |
|  AccessionNo | identifier["accessionNumber"]  |    accession.value    |


DxReport
--------

* id：DICOM 檔的 `SOPInstanceUID`
* identifier["totalPage"]：PDF 的總頁數


ImagingStudy
------------

* id：DICOM 檔的 `StudyInstanceUID`
* accession
	* system：reference 形式的 `Organization`
	* value：`AccessionNo`
	* assigner.display：Organization 的名稱


Patient
=======

* id：`orgId.patientId`。
	例如該假人所屬的 `Organization.id` 是「foo」、`PatientID` 是「12345」，則 id 為「foo.12345」
* identifier
	* system：reference 形式的 `Organization`。
	* value：該病患在指定機構當中的 `PatientID`

> ###### 備註 ######
> 病患的姓名、性別資訊只會認第一次進系統的那一筆資料。例如：
>
> * 檢查單號：9527 先進入 Archive，所帶的姓名為「唐伯虎」
> * 檢查單號：3310 後進入 Archive，所帶的姓名為「紙老虎」
>
> 兩筆為同一個 OrgId、PatientID 但系統只會儲存「唐伯虎」。


Person
======

* id：`PRSN.身份證號碼`。
	例如：該病患身份證號碼為「A1200548213」，則 id 為「PRSN.A1200548213」


Organization
=============

* id：`ORG.機構代碼`。
	例如：該機構代碼為「55688」，則 id 為「ORG.55688」，
	另外，機構代碼需能對應至 miobox 的機構（Institution）
