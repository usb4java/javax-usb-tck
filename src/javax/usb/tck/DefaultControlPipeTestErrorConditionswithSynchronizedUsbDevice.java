package javax.usb.tck;

/**
 * Copyright (c) 2004, International Business Machines Corporation.
 * All Rights Reserved.
 *
 * This software is provided and licensed under the terms and conditions
 * of the Common Public License:
 * http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
 */


import javax.usb.*;
import javax.usb.util.*;

import junit.framework.TestCase;

/**
 * Default Control Pipe Test -- Error Conditions
 * using UsbUtilSynchronizedUsbDevice
 * <p>
 * This test is the same as the DefaultControlPipeTestErrorConditions except a 
 * UsbUtil.SynchronizedUsbDevice is used in place of a UsbDevice.
 * <p>
 * This test verifies that control transfers operations work successfully
 * on the Default Control Pipe and that proper events are generated and proper
 * exceptions are thrown in the operation.
 *
 * @author Leslie Blair
 */

public class DefaultControlPipeTestErrorConditionswithSynchronizedUsbDevice extends TestCase
{
    public void setUp() throws Exception
    {
        originalUsbDevice = FindProgrammableDevice.getInstance().getProgrammableDevice();
        usbDevice = new UsbUtil.SynchronizedUsbDevice(originalUsbDevice);
        assertNotNull("Device required for test not found",usbDevice);
        DCPIRPTestErrorConditions = new DefaultControlPipeTestErrorConditions(usbDevice);
        super.setUp();

    }
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testUsbShortPacketException()
    {
        DCPIRPTestErrorConditions.testUsbShortPacketException();       
    };

    public void testUsbStallException()
    {
        DCPIRPTestErrorConditions.testUsbStallException();
    };

    public void testNotCallingsetDataForIRP()
    {
        DCPIRPTestErrorConditions.testNotCallingsetDataForIRP();
    };



    private UsbDevice originalUsbDevice;
    private UsbDevice usbDevice;
    DefaultControlPipeTestErrorConditions DCPIRPTestErrorConditions;
}
