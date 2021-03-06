/*
 * Copyright 2006 Jeremias Maerki.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krysalis.barcode4j.impl.datamatrix;

import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.TwoDimBarcodeLogicHandler;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.DefaultTwoDimCanvasLogicHandler;
import org.krysalis.barcode4j.output.Canvas;
import org.krysalis.barcode4j.output.CanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * This class is an implementation of DataMatrix (ISO 16022:2000(E)).
 * 
 * @version $Id: DataMatrixBean.java,v 1.3 2007/01/14 11:51:44 jmaerki Exp $
 */
public class DataMatrixBean extends AbstractBarcodeBean {

    /** The default module width (dot size) for DataMatrix. */
    protected static final double DEFAULT_MODULE_WIDTH = UnitConv.in2mm(1.0 / 72); //1px at 72dpi

    /** Create a new instance. */
    public DataMatrixBean() {
        this.height = 0.0; //not used by DataMatrix
        this.moduleWidth = DEFAULT_MODULE_WIDTH;
        this.quietZone = 1 * moduleWidth;
    }
    
    /**
     * @see org.krysalis.barcode4j.BarcodeGenerator#generateBarcode(CanvasProvider, String)
     */
    public void generateBarcode(CanvasProvider canvas, String msg) {
        if ((msg == null) 
                || (msg.length() == 0)) {
            throw new NullPointerException("Parameter msg must not be empty");
        }

        TwoDimBarcodeLogicHandler handler = 
                new DefaultTwoDimCanvasLogicHandler(this, new Canvas(canvas));

        DataMatrixLogicImpl impl = new DataMatrixLogicImpl();
        impl.generateBarcodeLogic(handler, msg);
    }
    
    /**
     * @see org.krysalis.barcode4j.BarcodeGenerator#calcDimensions(String)
     */
    public BarcodeDimension calcDimensions(String msg) {
        String encoded = DataMatrixHighLevelEncoder.encodeHighLevel(msg);
        DataMatrixSymbolInfo symbolInfo = DataMatrixSymbolInfo.lookup(encoded.length());
        
        double width = symbolInfo.getSymbolWidth() * getModuleWidth();
        double height = symbolInfo.getSymbolHeight() * getBarHeight(); 
        double qzh = (hasQuietZone() ? getQuietZone() : 0);        
        double qzv = (hasQuietZone() ? getVerticalQuietZone() : 0);        
        return new BarcodeDimension(width, height, 
                width + (2 * qzh), height + (2 * qzv), 
                qzh, qzv);
    }

    /** @see org.krysalis.barcode4j.impl.AbstractBarcodeBean#getVerticalQuietZone() */
    public double getVerticalQuietZone() {
        return getQuietZone();
    }

    /** @see org.krysalis.barcode4j.impl.AbstractBarcodeBean#getBarWidth(int) */
    public double getBarWidth(int width) {
        return moduleWidth;
    }
    
    /** @see org.krysalis.barcode4j.impl.AbstractBarcodeBean#getBarHeight() */
    public double getBarHeight() {
        return moduleWidth;
    }
    
}