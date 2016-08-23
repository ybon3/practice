> # Task-2 #
> * ���ءGGWT �}�o���һP Hello World
> * ��������Gpull request accept


�}�o����
========

* JDK 8
* Maven 3.3+
* Eclipse (�j�P��ĳ)
	* Google Plugin for Eclipse�]GPE�^
* Chrome (��ĳ)
* Tomcat / Jetty (option)

�����O�H Windows �� OS�A��L�@�~�t�νЦۦ�����C


���ҫظm
========

�H�U�Цۦ�ѨM

* JDK �w��
* Eclipse �w��


Maven
-----

1. �U�� [Maven](https://maven.apache.org/)�AV3.3+ ���i
1. �����Y���᪺�ؿ��A���]�s���m�� `c:\maven`
	* check point�G`c:\maven\bin\mvn.bat` �s�b
1. �]�w Windows �t�������ܼƤ����t���ܼ� `Path`�A�̥��ݥ[�W

		;c:\maven\bin;
		
	�άO�]�C���^�b cmd �U���O
	
		set path=%path%;c:\maven\bin;
		
1. �}�� cmd�A��J `mvn -version`
	* check point�G�X�{ Maven�BJDK ������T
	

Eclipse / GPE
-------------

1. Eclipse ready
1. Menu Bar��Help��Eclipse Marketplace
1. �b `Find` ��J `google` ���U enter
1. �M����� Eclipse ������ `Google Plugin for Eclipse`�A���U `Install`
	* �b�uConfirm Selected Features�v�����i�N�U�C�����Ŀ�]�[�ֳt�ס^
		* Google App Engine*


�}�o�y�{
========

**�`�N**�G�U�C�ާ@�|�ϥΨ� 8080�B9876 port�A���׶}�εۦۤv��ק�ϥ� port �����覡�C


�@���ʪ��ǳƤu�@
----------------

1. git clone �@�� [GwtSample] �� local repo�A
	���]���|�� `c:\repo\GwtSample`
1. �b Eclipse ��
	1. File��Import
	1. Maven��Existing Maven Projects
	1. Root Directory ��J `c:\repo\GwtSample`
1. �}�� cmd�A���� `c:\repo\GwtSample` �U�A����

		mvn install

1. �Ұ� GWT code server�G
	�}�� cmd�A���� `c:\repo\GwtSample` �U�A����

		mvn gwt:run-codeserver
		
	����e�����b
	
		The code server is ready at http://localhost:9876/
		
1. �}�� browser�A�s�� http://localhost:9876
1. �N�uDev Mode On�vdrag �� browser �� bookmark ��


�Ұ� web server
---------------

����ؤ覡�AMaven ���²��A���p�G�ݭn����� server-side code �N�|�ݭn�@���������_�ܳ·СC
Eclipse ���²��Bcode ���ܰʷ|�۰� reload�A���e���]�w�B�J����c���B�]����� resource�C


### Maven �Ұ� Tomcat 7 ###

�}�� cmd�A���� `c:\repo\GwtSample` �U�A����

	mvn war:exploded tomcat7:run
	

### Server in Eclipse ###

1. (�@���ʰʧ@) �N `c:\repo\GwtSample\target\GwtTest-0.0.1-SNAPSHOT\test` �o�ӥؿ��A
	�ƻs�� `c:\repo\GwtSample\src\main\webapp` �U
1. �s�W Server�B�[�J GwtSample�B�Ұ� server�]�Ӹ`���^


�Ұ� GWT 	
--------

1. �Ұ� web server		
1. �Ұ� GWT code server�G

		mvn gwt:run-codeserver

1. �}�� browser�A��J���} http://localhost:8080/

�C���ܧ� client side �� code�]�H�ثe�� case�A�N�O `com.dtc.test.client` �o�� package �H�U�� class�^�A
�ݭn���U���إߦb bookmark �Ϫ��uDev Mode On�v���uCompile�v


Task Feedback
==============

�иչϦ^���U�C���D�G

* [GwtSample] ���C���ɮס]`pom.xml` ���~�^���N�q�B�H�λP��L�ɮת����p�ʡC
	* �ХH�u�ɮסv���y�z���A�Ӥ��O�u�����C�@��{���X�v���覡�Ӧ^���C
* Task-2 ���B�J�����ǬO�����n���H�άO����n���@�k�H

�]�i���W�A���x�b�B���D�Τ߱o�C

1. �إߤ@�� branch�A�W�٬� `task-2`�A�ä�����o�� branch
1. �N feedback �g�b�ӤH�ؿ��U�� `Task-2.md`
1. �o pull request �� `MontyPan/Traning` �� `master`


[GwtSample]: https://github.com/DatacomRD/GwtSample