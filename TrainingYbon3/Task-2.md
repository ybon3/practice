Task Feedback
=============

> [GwtSample] ���C���ɮס]`pom.xml` ���~�^���N�q�B�H�λP��L�ɮת����p�ʡC


- src\main\java\com\dtc\test\Test.gwt.xml

	�P GWT ������ config file�A`<module>` �� `rename-to` �ݩʻP GWT �� `output` ���|�۹����C

- src\main\java\com\dtc\test\client\TestEP.java

	�O�@�� GWT Module�A�P `test.gwt.xml` ���� `entry-point` �����A�̭��]�t���� layout �]�w�A�H�� ui ���󪺦欰�C
	`start()` method ��@�F�D�P�B�� RPC�A�b RPC �^�����e�H print log per second ���覡�Ӫ�F�{���٦b���ݡC

- src\main\java\com\dtc\test\client\RpcService.java

	���ݵ{�ǩI�s�� API�A���ѵ� `TestEP.java` ���ݩI�s�C

- src\main\java\com\dtc\test\server\RpcServiceImpl.java

	��@ `RpcService.java`�A��{ RPC �ɪ� server �ݦ欰�C

- src\main\java\com\dtc\test\shared\exception.TestException.java

	`com.dtc.test` �۩w�q�� Exception�C

- src\main\webapp\index.html

	���������A�ޤJ `entry-point`�]`TestEP.java`�^�ӧe�{�e���H�εe�����󪺥\��C

- src\main\webapp\WEB-INF\web.xml

	j2ee �зǪ� config file�A�̭��w�q�F RPC �� URI�C

- �U�ɮ׶������p��

                Test.gwt.xml -- define --> TestEP.java
                                                |
                                               call
                                                |
                        RpcService.before() <---+
                                    ^
                                    |
                                implement
                                    |
                                    |
        web.xml -- define --> RpcServiceImpl -- throw --> TestException


> Task-2 ���B�J�����ǬO�����n���H�άO����n���@�k�H


�u�n�N `test\test.nocache.js` �ƻs�� `GwtSample\src\main\webapp\test` �U�N�n�A��L�ɮפ��νƻs�C


�x�b�B���D�Τ߱o
================

1. GPE �ثe���G�u�䴩�� Java 1.7�A�ϥ� JDK 8 �٥����� IDE �i��uCompiler compliance level�v���վ�AWhy JDK 8�H


	[App Engine does not yet support Java 8] [GPfE]


1. ��_�@�ִ��ѫ�ĳ�� Eclipse �����H
1. �uEclipse / GPE�v���B�J 4 ���A�d�ߵ��G���䤣�� Google Plugin for Eclipse�]�٤@���X�{ Error�^�C��ĳ�ϥ� Menu Bar��Help��Install New Software ���w�ˤ覡�C
 

	[Google Plugin for Eclipse 4.6 (Neon) Installation Instructions] [Installation]


1. �uMaven�v���B�J 2 �� `check point�Gc:\maven\bin\mvn.bat` ���s�b�]���� `mvn.cmd`�^
1. �u�Ұ� web server�v���оǤ��A�������ӬO Maven ���²��A�ӫD��ؤ覡���u���²��v�C
1. ���F `Ctrl-C` ���~�٦��O����k���� codeserver �ܡH�]���o�ͤ��p�߱N command-line �����o�L�k���� codeserver �B�@�����D�C
1. �g�ѳo�� Task �ڹ� GWT ���B�@�覡���F��B�{�ѡA�ثeı�o�̯S�O���O codeserver ���s�b�CGWT �� client �{���ܰʻݳz�L���Ҫ��覡�I�s codeserver �Ӷi�� compile�A�ק諸���G�~�|���T�a��ܦb�e�ݭ����A�o�N��F�b GWT compile �L���e�ݸ귽����b codeserver�A���L����ڪ��B�@�覡�٬O�@���b�ѡC
 

[GPfE]: https://developers.google.com/eclipse/docs/getting_started?hl=zh-TW
[Installation]: https://github.com/DatacomRD/GwtSample