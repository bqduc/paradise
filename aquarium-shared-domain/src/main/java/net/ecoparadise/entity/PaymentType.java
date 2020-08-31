/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.ecoparadise.entity;

/**
 *
 * @author haky
 */
public enum PaymentType {
    Cash, //nakit
    Cheque,  //cek
    PromissoryNote, //senet
    CreditCard, //Kredi kartı
    Instalment, //taksitli ödeme
    DebitCard,  // banka atm kartı
    GiftCheque, //hediye çeki
    Contribution, //katkı payı ödemesi
    BonusPay //kredi kartından puanla ödeme
}
