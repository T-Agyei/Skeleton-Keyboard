package com.example.skeletonkeyboard

import android.annotation.SuppressLint
import android.inputmethodservice.InputMethodService
import android.media.AudioManager
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class SkeletonIME : InputMethodService(), View.OnClickListener {
    private var currentKB: View? = null
    private var lowercaseKB: View? = null
    private var uppercaseKB: View? = null
    private var uppershiftcaseKB: View? = null
    private var numpadKB:View? = null

    @SuppressLint("InflateParams")
    override fun onCreateInputView(): View {

        lowercaseKB = layoutInflater.inflate(R.layout.lowercase_layout,null)
        uppercaseKB = layoutInflater.inflate(R.layout.uppercase_layout,null)
        uppershiftcaseKB = layoutInflater.inflate(R.layout.uppershift_layout,null)
        numpadKB = layoutInflater.inflate(R.layout.numpad_layout,null)

        //Keys

        val btnLCKeyq = lowercaseKB!!.findViewById<Button>(R.id.lowercaseq)
        val btnLCKeyw = lowercaseKB!!.findViewById<Button>(R.id.lowercasew)
        val btnLCKeye = lowercaseKB!!.findViewById<Button>(R.id.lowercasee)
        val btnLCKeyr = lowercaseKB!!.findViewById<Button>(R.id.lowercaser)
        val btnLCKeyt = lowercaseKB!!.findViewById<Button>(R.id.lowercaset)
        val btnLCKeyy = lowercaseKB!!.findViewById<Button>(R.id.lowercasey)
        val btnLCKeyu = lowercaseKB!!.findViewById<Button>(R.id.lowercaseu)
        val btnLCKeyi = lowercaseKB!!.findViewById<Button>(R.id.lowercasei)
        val btnLCKeyo = lowercaseKB!!.findViewById<Button>(R.id.lowercaseo)
        val btnLCKeyp = lowercaseKB!!.findViewById<Button>(R.id.lowercasep)
        val btnLCKeya = lowercaseKB!!.findViewById<Button>(R.id.lowercasea)
        val btnLCKeys = lowercaseKB!!.findViewById<Button>(R.id.lowercases)
        val btnLCKeyd = lowercaseKB!!.findViewById<Button>(R.id.lowercased)
        val btnLCKeyf = lowercaseKB!!.findViewById<Button>(R.id.lowercasef)
        val btnLCKeyg = lowercaseKB!!.findViewById<Button>(R.id.lowercaseg)
        val btnLCKeyh = lowercaseKB!!.findViewById<Button>(R.id.lowercaseh)
        val btnLCKeyj = lowercaseKB!!.findViewById<Button>(R.id.lowercasej)
        val btnLCKeyk = lowercaseKB!!.findViewById<Button>(R.id.lowercasek)
        val btnLCKeyl = lowercaseKB!!.findViewById<Button>(R.id.lowercasel)
        val btnLCKeyz = lowercaseKB!!.findViewById<Button>(R.id.lowercasez)
        val btnLCKeyx = lowercaseKB!!.findViewById<Button>(R.id.lowercasex)
        val btnLCKeyc = lowercaseKB!!.findViewById<Button>(R.id.lowercasec)
        val btnLCKeyv = lowercaseKB!!.findViewById<Button>(R.id.lowercasev)
        val btnLCKeyb = lowercaseKB!!.findViewById<Button>(R.id.lowercaseb)
        val btnLCKeyn = lowercaseKB!!.findViewById<Button>(R.id.lowercasen)
        val btnLCKeym = lowercaseKB!!.findViewById<Button>(R.id.lowercasem)
        val btnLCKey123 = lowercaseKB!!.findViewById<Button>(R.id.lowercase123)
        val btnLCKeyabc = lowercaseKB!!.findViewById<Button>(R.id.lowercaseabc)
        val btnLCKeycomma = lowercaseKB!!.findViewById<Button>(R.id.lowercasecomma)
        val btnLCKeyperiod = lowercaseKB!!.findViewById<Button>(R.id.lowercaseperiod)
        val btnLCKeyspace = lowercaseKB!!.findViewById<Button>(R.id.lowercasespace)
        val btnLCKeyshift = lowercaseKB!!.findViewById<ImageButton>(R.id.lowercaseshift)
        val btnLCKeydel = lowercaseKB!!.findViewById<ImageButton>(R.id.lowercasedelete)
        val btnLCKeydone = lowercaseKB!!.findViewById<ImageButton>(R.id.lowercasedone)

        btnLCKeyq.setOnClickListener(this)
        btnLCKeyw.setOnClickListener(this)
        btnLCKeye.setOnClickListener(this)
        btnLCKeyr.setOnClickListener(this)
        btnLCKeyt.setOnClickListener(this)
        btnLCKeyy.setOnClickListener(this)
        btnLCKeyu.setOnClickListener(this)
        btnLCKeyi.setOnClickListener(this)
        btnLCKeyo.setOnClickListener(this)
        btnLCKeyp.setOnClickListener(this)
        btnLCKeya.setOnClickListener(this)
        btnLCKeys.setOnClickListener(this)
        btnLCKeyd.setOnClickListener(this)
        btnLCKeyf.setOnClickListener(this)
        btnLCKeyg.setOnClickListener(this)
        btnLCKeyh.setOnClickListener(this)
        btnLCKeyj.setOnClickListener(this)
        btnLCKeyk.setOnClickListener(this)
        btnLCKeyl.setOnClickListener(this)
        btnLCKeyz.setOnClickListener(this)
        btnLCKeyx.setOnClickListener(this)
        btnLCKeyc.setOnClickListener(this)
        btnLCKeyv.setOnClickListener(this)
        btnLCKeyb.setOnClickListener(this)
        btnLCKeyn.setOnClickListener(this)
        btnLCKeym.setOnClickListener(this)
        btnLCKeyshift.setOnClickListener(this)
        btnLCKeydel.setOnClickListener(this)
        btnLCKeydone.setOnClickListener(this)
        btnLCKeyspace.setOnClickListener(this)
        btnLCKey123.setOnClickListener(this)
        btnLCKeyabc.setOnClickListener(this)
        btnLCKeycomma.setOnClickListener(this)
        btnLCKeyperiod.setOnClickListener(this)

        val btnUCKeyQ = uppercaseKB!!.findViewById<Button>(R.id.uppercaseQ)
        val btnUCKeyW = uppercaseKB!!.findViewById<Button>(R.id.uppercaseW)
        val btnUCKeyE = uppercaseKB!!.findViewById<Button>(R.id.uppercaseE)
        val btnUCKeyR = uppercaseKB!!.findViewById<Button>(R.id.uppercaseR)
        val btnUCKeyT = uppercaseKB!!.findViewById<Button>(R.id.uppercaseT)
        val btnUCKeyY = uppercaseKB!!.findViewById<Button>(R.id.uppercaseY)
        val btnUCKeyU = uppercaseKB!!.findViewById<Button>(R.id.uppercaseU)
        val btnUCKeyI = uppercaseKB!!.findViewById<Button>(R.id.uppercaseI)
        val btnUCKeyO = uppercaseKB!!.findViewById<Button>(R.id.uppercaseO)
        val btnUCKeyP = uppercaseKB!!.findViewById<Button>(R.id.uppercaseP)
        val btnUCKeyA = uppercaseKB!!.findViewById<Button>(R.id.uppercaseA)
        val btnUCKeyS = uppercaseKB!!.findViewById<Button>(R.id.uppercaseS)
        val btnUCKeyD = uppercaseKB!!.findViewById<Button>(R.id.uppercaseD)
        val btnUCKeyF = uppercaseKB!!.findViewById<Button>(R.id.uppercaseF)
        val btnUCKeyG = uppercaseKB!!.findViewById<Button>(R.id.uppercaseG)
        val btnUCKeyH = uppercaseKB!!.findViewById<Button>(R.id.uppercaseH)
        val btnUCKeyJ = uppercaseKB!!.findViewById<Button>(R.id.uppercaseJ)
        val btnUCKeyK = uppercaseKB!!.findViewById<Button>(R.id.uppercaseK)
        val btnUCKeyL = uppercaseKB!!.findViewById<Button>(R.id.uppercaseL)
        val btnUCKeyZ = uppercaseKB!!.findViewById<Button>(R.id.uppercaseZ)
        val btnUCKeyX = uppercaseKB!!.findViewById<Button>(R.id.uppercaseX)
        val btnUCKeyC = uppercaseKB!!.findViewById<Button>(R.id.uppercaseC)
        val btnUCKeyV = uppercaseKB!!.findViewById<Button>(R.id.uppercaseV)
        val btnUCKeyB = uppercaseKB!!.findViewById<Button>(R.id.uppercaseB)
        val btnUCKeyN = uppercaseKB!!.findViewById<Button>(R.id.uppercaseN)
        val btnUCKeyM = uppercaseKB!!.findViewById<Button>(R.id.uppercaseM)
        val btnUCKey123 = uppercaseKB!!.findViewById<Button>(R.id.uppercase123)
        val btnUCKeyAbc = uppercaseKB!!.findViewById<Button>(R.id.uppercaseabc)
        val btnUCKeyComma = uppercaseKB!!.findViewById<Button>(R.id.uppercasecomma)
        val btnUCKeyPeriod = uppercaseKB!!.findViewById<Button>(R.id.uppercaseperiod)
        val btnUCKeySpace = uppercaseKB!!.findViewById<Button>(R.id.uppercasespace)
        val btnUCKeyShift = uppercaseKB!!.findViewById<ImageButton>(R.id.uppercaseshift)
        val btnUCKeyDel = uppercaseKB!!.findViewById<ImageButton>(R.id.uppercasedelete)
        val btnUCKeyDone = uppercaseKB!!.findViewById<ImageButton>(R.id.uppercasedone)

        btnUCKeyQ.setOnClickListener(this)
        btnUCKeyW.setOnClickListener(this)
        btnUCKeyE.setOnClickListener(this)
        btnUCKeyR.setOnClickListener(this)
        btnUCKeyT.setOnClickListener(this)
        btnUCKeyY.setOnClickListener(this)
        btnUCKeyU.setOnClickListener(this)
        btnUCKeyI.setOnClickListener(this)
        btnUCKeyO.setOnClickListener(this)
        btnUCKeyP.setOnClickListener(this)
        btnUCKeyA.setOnClickListener(this)
        btnUCKeyS.setOnClickListener(this)
        btnUCKeyD.setOnClickListener(this)
        btnUCKeyF.setOnClickListener(this)
        btnUCKeyG.setOnClickListener(this)
        btnUCKeyH.setOnClickListener(this)
        btnUCKeyJ.setOnClickListener(this)
        btnUCKeyK.setOnClickListener(this)
        btnUCKeyL.setOnClickListener(this)
        btnUCKeyZ.setOnClickListener(this)
        btnUCKeyX.setOnClickListener(this)
        btnUCKeyC.setOnClickListener(this)
        btnUCKeyV.setOnClickListener(this)
        btnUCKeyB.setOnClickListener(this)
        btnUCKeyN.setOnClickListener(this)
        btnUCKeyM.setOnClickListener(this)
        btnUCKeyShift.setOnClickListener(this)
        btnUCKeyDel.setOnClickListener(this)
        btnUCKeyDone.setOnClickListener(this)
        btnUCKeySpace.setOnClickListener(this)
        btnUCKey123.setOnClickListener(this)
        btnUCKeyAbc.setOnClickListener(this)
        btnUCKeyComma.setOnClickListener(this)
        btnUCKeyPeriod.setOnClickListener(this)

        val btnUSKeyQ = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftQ)
        val btnUSKeyW = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftW)
        val btnUSKeyE = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftE)
        val btnUSKeyR = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftR)
        val btnUSKeyT = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftT)
        val btnUSKeyY = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftY)
        val btnUSKeyU = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftU)
        val btnUSKeyI = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftI)
        val btnUSKeyO = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftO)
        val btnUSKeyP = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftP)
        val btnUSKeyA = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftA)
        val btnUSKeyS = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftS)
        val btnUSKeyD = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftD)
        val btnUSKeyF = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftF)
        val btnUSKeyG = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftG)
        val btnUSKeyH = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftH)
        val btnUSKeyJ = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftJ)
        val btnUSKeyK = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftK)
        val btnUSKeyL = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftL)
        val btnUSKeyZ = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftZ)
        val btnUSKeyX = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftX)
        val btnUSKeyC = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftC)
        val btnUSKeyV = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftV)
        val btnUSKeyB = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftB)
        val btnUSKeyN = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftN)
        val btnUSKeyM = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftM)
        val btnUSKey123 = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershift123)
        val btnUSKeyAbc = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftabc)
        val btnUSKeyComma = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftcomma)
        val btnUSKeyPeriod = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftperiod)
        val btnUSKeySpace = uppershiftcaseKB!!.findViewById<Button>(R.id.uppershiftspace)
        val btnUSKeyShift = uppershiftcaseKB!!.findViewById<ImageButton>(R.id.uppershiftShift)
        val btnUSKeyDel = uppershiftcaseKB!!.findViewById<ImageButton>(R.id.uppershiftdelete)
        val btnUSKeyDone = uppershiftcaseKB!!.findViewById<ImageButton>(R.id.uppershiftdone)

        btnUSKeyQ.setOnClickListener(this)
        btnUSKeyW.setOnClickListener(this)
        btnUSKeyE.setOnClickListener(this)
        btnUSKeyR.setOnClickListener(this)
        btnUSKeyT.setOnClickListener(this)
        btnUSKeyY.setOnClickListener(this)
        btnUSKeyU.setOnClickListener(this)
        btnUSKeyI.setOnClickListener(this)
        btnUSKeyO.setOnClickListener(this)
        btnUSKeyP.setOnClickListener(this)
        btnUSKeyA.setOnClickListener(this)
        btnUSKeyS.setOnClickListener(this)
        btnUSKeyD.setOnClickListener(this)
        btnUSKeyF.setOnClickListener(this)
        btnUSKeyG.setOnClickListener(this)
        btnUSKeyH.setOnClickListener(this)
        btnUSKeyJ.setOnClickListener(this)
        btnUSKeyK.setOnClickListener(this)
        btnUSKeyL.setOnClickListener(this)
        btnUSKeyZ.setOnClickListener(this)
        btnUSKeyX.setOnClickListener(this)
        btnUSKeyC.setOnClickListener(this)
        btnUSKeyV.setOnClickListener(this)
        btnUSKeyB.setOnClickListener(this)
        btnUSKeyN.setOnClickListener(this)
        btnUSKeyM.setOnClickListener(this)
        btnUSKeyShift.setOnClickListener(this)
        btnUSKeyDel.setOnClickListener(this)
        btnUSKeyDone.setOnClickListener(this)
        btnUSKeySpace.setOnClickListener(this)
        btnUSKey123.setOnClickListener(this)
        btnUSKeyAbc.setOnClickListener(this)
        btnUSKeyComma.setOnClickListener(this)
        btnUSKeyPeriod.setOnClickListener(this)

        val btnNumpad1 = numpadKB!!.findViewById<Button>(R.id.numpad1)
        val btnNumpad2 = numpadKB!!.findViewById<Button>(R.id.numpad2)
        val btnNumpad3 = numpadKB!!.findViewById<Button>(R.id.numpad3)
        val btnNumpad4 = numpadKB!!.findViewById<Button>(R.id.numpad4)
        val btnNumpad5 = numpadKB!!.findViewById<Button>(R.id.numpad5)
        val btnNumpad6 = numpadKB!!.findViewById<Button>(R.id.numpad6)
        val btnNumpad7 = numpadKB!!.findViewById<Button>(R.id.numpad7)
        val btnNumpad8 = numpadKB!!.findViewById<Button>(R.id.numpad8)
        val btnNumpad9 = numpadKB!!.findViewById<Button>(R.id.numpad9)
        val btnNumpad0 = numpadKB!!.findViewById<Button>(R.id.numpad0)
        val btnNumpadPlus = numpadKB!!.findViewById<Button>(R.id.numpadplus)
        val btnNumpadAbc = numpadKB!!.findViewById<Button>(R.id.numpadabc)
        val btnNumpadComma = numpadKB!!.findViewById<Button>(R.id.numpadcomma)
        val btnNumpadPeriod = numpadKB!!.findViewById<Button>(R.id.numpadperiod)
        val btnNumpadSpace = numpadKB!!.findViewById<Button>(R.id.numpadspace)
        val btnNumpadDel = numpadKB!!.findViewById<ImageButton>(R.id.numpaddelete)
        val btnNumpadDone = numpadKB!!.findViewById<ImageButton>(R.id.numpaddone)

        btnNumpad1.setOnClickListener(this)
        btnNumpad2.setOnClickListener(this)
        btnNumpad3.setOnClickListener(this)
        btnNumpad4.setOnClickListener(this)
        btnNumpad5.setOnClickListener(this)
        btnNumpad6.setOnClickListener(this)
        btnNumpad7.setOnClickListener(this)
        btnNumpad8.setOnClickListener(this)
        btnNumpad9.setOnClickListener(this)
        btnNumpad0.setOnClickListener(this)
        btnNumpadPlus.setOnClickListener(this)
        btnNumpadAbc.setOnClickListener(this)
        btnNumpadComma.setOnClickListener(this)
        btnNumpadPeriod.setOnClickListener(this)
        btnNumpadSpace.setOnClickListener(this)
        btnNumpadDel.setOnClickListener(this)
        btnNumpadDone.setOnClickListener(this)

        currentKB = lowercaseKB

        return currentKB!!
    }

    override fun onClick(v: View?) {
        val ic = currentInputConnection
        val am = getSystemService(AUDIO_SERVICE) as AudioManager

        capsToLower(v!!)

        when(v) {
            is Button -> {
                val kbKey = v.text.toString()
                when(v.tag.toString()) {
                    "SPACE" -> {
                        ic.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE))
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR)
                    }
                    "ABC" -> {
                        currentKB = lowercaseKB
                        setInputView(currentKB)
                    }
                    "123" -> {
                        currentKB = numpadKB
                        setInputView(currentKB)
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD)
                    }
                    else -> {
                        ic.commitText(kbKey,1)
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD)
                    }
                }
            }

            is ImageButton -> {
                when(v.tag.toString()) {
                    "SHIFT" -> {
                        onShiftPressed(v)
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD)
                    }
                    "DELETE" -> {
                        ic.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE)
                    }
                    "DONE" -> {
                        ic.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
                        am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN)
                    }
                }
            }
        }
    }

    // Next two functions handles Shift key

    private fun capsToLower(v:View) {
        if (currentKB == uppershiftcaseKB && v != v.findViewById(R.id.uppershiftShift))
        {
            currentKB = lowercaseKB
            setInputView(currentKB)
        }
    }

    private fun onShiftPressed(v:View) {
        when(v) {
            v.findViewById<Button>(R.id.lowercaseshift) -> {
                currentKB = uppershiftcaseKB
                setInputView(currentKB)
            }
            v.findViewById<Button>(R.id.uppershiftShift) -> {
                currentKB = uppercaseKB
                setInputView(currentKB)
            }
            v.findViewById<Button>(R.id.uppercaseshift) -> {
                currentKB = lowercaseKB
                setInputView(currentKB)
            }
        }
    }
}