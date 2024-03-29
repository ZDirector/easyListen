package com.example.homepage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.homepage.R

class ContentServiceActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val tv = findViewById<TextView>(R.id.tv_detail_content)
        if (intent.getIntExtra("content_style",1)==1){
            tv.text="平台用户协议（以下简称“本协议”）由以下双方根据《中华人民共和国合同法》等相关法律法规签署并遵照执行。\n" +
                    "\n" +
                    "用户：在手机、平板电脑、电脑等注册成为平台（以下简称“平台”或“平台方”）的使用者，通过平台发布、查看、接收图文/音频/视频信息或其他文件，或与其他用户进行延时/实时交流的用户（以下简称“用户”）。\n" +
                    "\n" +
                    "平台方：北京世纪超星信息技术发展有限责任公司（以下简称“平台方”）。\n" +
                    "\n" +
                    "本协议所指“用户”包括但不限于教师身份用户、家长身份用户和学生身份用户。\n" +
                    "\n" +
                    "第一条 用户注册\n" +
                    "1.1用户下载平台并根据平台的注册规则完成注册流程（包括但不限于设置用户名称及密码）后，即有权通过平台发布、查看、接收图文/音频/视频信息或其他文件，或与其他用户进行延时/实时交流。用户在平台上有效注册（或有效变更注册）的用户名及密码共同构成用户在平台的唯一有效身份证明。\n" +
                    "\n" +
                    "1.2用户一旦完成注册，则视为用户允许平台方通过短信、电子邮件、APP/服务器推送或其他方式向其发送与平台相关的信息。\n" +
                    "\n" +
                    "1.3用户应当保证其完成上述注册（或变更注册）时所提供的身份信息及电话、电子邮箱等必要信息真实、准确、有效；如此类信息有任何变动，用户应当在三日内通过平台完成信息更新。因用户提供虚假或无效信息导致平台方或其他用户遭受损失的，用户应当承担全部责任。\n" +
                    "\n" +
                    "1.4用户应自行妥善保管用户名及密码，除经平台方事先书面同意或本协议另有约定外，不得将其赠予、转让、出售或出借于他人使用；如用户发现其用户名及密码遭他人使用，应立即通知平台方以避免损失或损失扩大。因网络攻击、用户保管用户名及密码不当、转让或出借用户名及密码、怠于履行本协议及其他相关协议下的通知义务等情形或其他非平台方原因，导致用户未能正常使用平台或遭受任何损失的，由用户自行担责，平台方不承担任何责任。\n" +
                    "\n" +
                    "1.5用户需自行确认，在开始注册使用平台前，其应当具备中华人民共和国法律规定的与其行为相适应的民事行为能力。若用户不具备前述与用户行为相适应的民事行为能力，则其监护人应依照法律规定承担此用户行为产生的一切法律后果（未成年人应在其监护人监督指导下使用平台）。\n" +
                    "\n" +
                    "1.6用户注册的账户为用户自行设置并由用户自行保管，平台方任何时候均不会主动要求用户提供其账户密码。用户账户因用户的主动泄露或遭受他人攻击、诈骗等行为导致的损失及后果，平台方不承担责任，用户应自行通过司法、行政等救济途径向侵权行为人追偿。\n" +
                    "\n" +
                    "1.7如发生以下情形，平台方有权收回用户注册的账户，用户将不能再登录平台，相应服务同时终止：\n" +
                    "\n" +
                    "（一）经发现非由注册用户本人实际使用的；\n" +
                    "\n" +
                    "（二）连续三个月未用于登录平台；\n" +
                    "\n" +
                    "（三）其他平台方认为有必要的情形。\n" +
                    "\n" +
                    "1.8用户一旦完成注册，即视为完全了解、接受并同意遵守本协议项下的全部内容并受限于本协议相关条款。平台方有权根据法律法规、政策以及运营中的实际情况对协议进行修改，并对用户进行公布。修改后的协议条款一经平台方公布即替换本协议的原条款，构成用户与平台方之间就本协议的全部、最新协议。用户可以随时在平台应用程序中查阅最新协议条款。如果用户不接受平台方修改后的最新协议条款，可选择停止使用平台并注销其账户。如用户选择继续使用平台，则视为用户完全了解、接受并同意遵守平台方修改后的最新协议条款。用户承认并认可，已经完全了解并理解本协议相关内容，对本协议及相关内容不存在任何重大误解；同时认可本协议内容并不存在显失公平的情形，用户与平台方在协议中处于平等地位，用户对协议的接受与否具有自由选择的权利。\n" +
                    "\n" +
                    "第二条 服务内容\n" +
                    "2.1平台方为用户提供发布、查看、接收图文/音频/视频信息或其他文件，或与其他用户进行延时/实时交流的服务。\n" +
                    "\n" +
                    "2.2平台方作为平台软件的设计/开发/所有/经营者，有权对于平台软件不时作出更新和调整，只要用户仍为平台的注册用户，即视为其同意平台方作出的任何更新和调整。\n" +
                    "\n" +
                    "2.3平台方仅为用户提供发布、查看、接收图文/音频/视频信息或其他文件，或与其他用户进行延时/实时交流的技术支持，因用户自身原因造成的延迟确认、延迟回复、未按时保存、操作失误等情形，平台方不承担任何责任。\n" +
                    "\n" +
                    "2.4用户应当知晓在使用平台软件的过程中可能存在由其他用户进行通知、提醒、审批、定时、评论、发起问卷、投票等行为设置，平台方仅为前述行为提供技术支持，前述行为均为用户自身行为，与平台方无关。\n" +
                    "\n" +
                    "2.5用户应当知晓在使用平台软件的过程中可能涉及第三方服务软件的参与（包括但不限于微信、QQ、支付宝等），因前述第三方服务软件所造成的信息提供错误、信息提供延误、信息泄露、连接错误、服务器故障等情形与平台方无关。\n" +
                    "\n" +
                    "第三条 各方的权利义务\n" +
                    "3.1 用户的权利义务\n" +
                    "\n" +
                    "3.1.1用户应遵守中国有关的法律法规规定及本协议约定条款。\n" +
                    "\n" +
                    "3.1.2用户向平台提供的各类信息应真实、准确、完整；用户在平台发布的各类信息（包括但不限于图文、音频、视频等）应符合中国有关的法律法规；用户通过平台进行的延时/实时交流活动应当符合中国有关的法律法规。经平台方发现用户违反前述约定的，用户向平台提供/发布的信息将不再适用本合同有关隐私保护的约定，平台方有权公示、向政府部门进行举报或直接向用户追究法律责任。平台方在任何时候有权验证用户提供/发布的信息，由于用户提供虚假或不完整信息所导致的任何责任和损失，应由用户自行承担。\n" +
                    "\n" +
                    "3.1.3用户利用平台发布虚假、侵犯他人隐私、侵犯他人知识产权、侮辱他人、造谣诽谤等违反法律法规或公序良俗的内容从而给平台方、其他用户或第三方造成损害的，由前述用户承担全部法律后果及赔偿责任。\n" +
                    "\n" +
                    "3.1.4用户不得有任何损害平台方权益的行为，若用户损害平台方权益的，平台方有权要求用户承担赔偿责任，情节严重的平台方将保留追究其法律责任的权利。\n" +
                    "\n" +
                    "3.1.5平台方暂时免费向用户提供本协议约定之服务，但平台方保留将来向用户收取费用的权利。用户之间自行产生的任何费用支付均与平台方无关。\n" +
                    "\n" +
                    "3.2平台方的权利义务\n" +
                    "\n" +
                    "3.2.1在平台的变更、更新、优化后，及时通知用户。\n" +
                    "\n" +
                    "3.2.2平台无法保证其所提供的信息中没有任何错误、缺陷、恶意软件或病毒。对于因使用（或无法使用）平台导致的任何损害，平台不承担责任（除非此类损害是由平台的故意或重大疏忽造成的）。此外，对于因使用（或无法使用）与平台的电子通信手段导致的任何损害，包括但不限于因电子通信传达失败或延时、第三方或用于电子通信的计算机程序对电子通信的拦截或操纵，以及病毒传输导致的损害，平台不承担责任。\n" +
                    "\n" +
                    "第四条 其他责任约定\n" +
                    "4.1因不可抗力（指本协议约定时不能预见、不能避免并不能克服的客观情况）导致平台方未能按约提供服务的，平台方不承担责任。\n" +
                    "\n" +
                    "4.2服务过程中因协议双方以外的其他第三方原因造成的损失，由该第三方承担法律后果及赔偿责任。\n" +
                    "\n" +
                    "第五条 用户信息\n" +
                    "5.1 用户信息包含用户个人信息和用户非个人信息。\n" +
                    "\n" +
                    "5.2用户个人信息包括但不限于下列信息：用户真实姓名、性别、职业、任职/就读学校、头像、手机号码、IP地址等。\n" +
                    "\n" +
                    "5.3用户非个人信息包括但不限下列信息：一切属于第5.2条所述的用户个人信息范围以外的信息，均为普通信息，不属于用户个人信息；包括但不限于用户对平台服务的操作状态、使用记录、使用习惯等反应在平台方服务器端的全部记录信息。\n" +
                    "\n" +
                    "5.4重要提示：为向客户提供本协议所述服务，平台方将可能合理使用用户个人信息和非用户个人信息。用户一旦注册、登录、使用平台，将视为用户完全了解、同意并接受平台方通过包括但不限于收集、统计、分析、使用等方式合理使用用户信息，无需其他意思表示。为向用户完整地提供包括但不限于本协议所述的服务，平台方将可能要求用户上传用户信息（包括但不限于通讯录等），用户一旦选择上传用户信息，将视为用户完全了解、同意并接受平台方基于向用户提供服务的目的读取并合理使用用户信息。\n" +
                    "\n" +
                    "5.5用户认可其已完全了解平台方使用用户信息的目的在于为用户提供包括本协议所述的服务或将来可能新增的服务，平台方使用用户信息的方式包括但不限于：收集、统计、分析、商业用途的使用等方式；平台方使用用户信息的范围包括但不限于本条第5.2条、5.3条、5.4条所定义的信息等。\n" +
                    "\n" +
                    "5.6用户可以通过停止使用平台而不再向平台方提供用户信息。但是，在此之前已同意平台方使用的用户信息，平台方不承担主动删除、销毁的责任，并仍具有使用此类用户信息的权利。\n" +
                    "\n" +
                    "5.7除非用户另有特别声明，平台方对用户信息的使用无需向用户支付任何费用，并且在用户同意本协议的基础上，无需向用户另行取得授权。\n" +
                    "\n" +
                    "5.8平台方尊重用户的合法权利，不会以违反法律、行政法规以及本协议约定的方式收集、使用用户信息。\n" +
                    "\n" +
                    "5.9非因平台方违反本协议的约定而导致的用户信息的泄露与平台方无关。任何用户（包括但不限于教师身份用户、家长身份用户、学生身份用户）不得利用、泄露、散播通过平台获取的其他用户的用户信息；用户发生前述行为的，平台方不承担任何责任，由前述侵权用户承担全部责任。任何平台方、用户外的第三方不得利用、泄露、散播通过平台获取的其他用户的用户信息，第三方发生前述行为的，平台方不承担任何责任，由该第三方承担全部责任。\n" +
                    "\n" +
                    "5.10平台方对按照有关法律法规要求、按照相关政府主管部门/司法机关的要求而披露用户信息的行为不承担任何责任。\n" +
                    "\n" +
                    "第六条 知识产权\n" +
                    "6.1 本协议所指知识产权是指与平台服务相关的各类过去有效的、现行有效的、或即将产生的知识产权，包括但不限于商标、著作权、计算机软件、发明、实用新型、外观设计以及提出相关申请的权利。\n" +
                    "\n" +
                    "6.2平台方为与平台服务相关的全部知识产权的权利人，对平台服务提供过程中包含的全部知识产权，包括但不限于文本、图片、图形、音频和/或视频资料享有及保留完整、独立的全部权利。未经平台方同意，用户及第三方不得在任何媒体直接或间接发布、播放、出于播放或发布目的而改写或再发行平台方享有的知识产权或者平台方提供的任何资料和信息，也不得将前述资料和信息用于任何商业目的。\n" +
                    "\n" +
                    "6.3对于用户本人创作并上传到平台的任何图文/音频/视频等，平台方保留对其内容进行监控的权利，并有权依平台方独立判断对任何违反本协议约定或涉嫌违法、违规的内容实施删除操作。平台方对于删除此类用户作品引起的任何后果或导致用户的任何损失不负任何责任。\n" +
                    "\n" +
                    "6.4知识产权条款持续有效，不因用户关闭平台账户或者停止使用平台服务而失效。\n" +
                    "\n" +
                    "第七条 其他免责声明\n" +
                    "7.1平台方或用户提供的全部信息仅依照此类信息提供时的现状提供并仅供用户参考，平台方不对前述信息的真实性、准确性、完整性、适用性等做任何承诺和保证。用户应对平台方或其他用户提供的信息自行判断，并承担因使用前述信息而引起的全部风险，包括因其对信息的真实性、准确性、完整性或适用性的任何依赖或信任而导致的风险。平台方无需对因用户使用信息的任何行为导致的任何损失承担责任。\n" +
                    "\n" +
                    "7.2对于因不可抗力或平台方不能预料、不能控制的原因（包括但不限于计算机病毒或黑客攻击、系统不稳定、用户不当使用账户、以及其他任何技术、互联网络、通信线路原因等）产生的包括但不限于用户计算机信息和数据的安全问题，用户个人信息的安全问题等给用户或任何第三方造成的损失，平台方不承担任何责任。\n" +
                    "\n" +
                    "7.3用户因违法、违规或违反本协议约定使用平台的行为，包括但不限于提供违法、不真实、不正当信息，侵犯第三方任何合法权益等，给平台方或其他第三方造成的任何损失，由用户自身承担由此造成的全部法律后果及损害赔偿责任。\n" +
                    "\n" +
                    "7.4用户完全了解并同意，在使用平台服务的过程中，可能存在来自任何其他用户的包括威胁性的、诽谤性的、令人反感的或非法的内容或行为，也可能存在对他人权利（包括知识产权）造成侵犯的匿名、冒名、或伪造的各种信息或行为，用户须自行判断相关内容、信息、行为的安全性等风险，并自行独立承担因上述行为给平台方、其他用户或第三方造成损害的一切法律后果。\n" +
                    "\n" +
                    "7.5平台方对其合作方通过平台提供的全部服务及内容不作任何形式的承诺或保证，不论是明确的或暗示的。前述承诺或保证包括但不限于：第三方通过平台提供的服务或内容的真实性、时效性、对特定用途的适用性、任何形式的所有权保证，非侵权保证等。平台方对因前述第三方服务内容导致的任何直接、间接、偶然、特殊及后续的损害，不承担任何责任。\n" +
                    "\n" +
                    "7.6本平台在为用户提供 信息存储空间服务的同时，十分重视互联网环境的绿色、健康以及其他用户的知识产权和其他合法权益的保护。用户在上传分享内容时，须注意不得侵犯任何个人、企事业单位或社会团体的合法权益,包括但不限于姓名权、名称权、名誉权、荣誉权、肖像权、隐私权、知识产权等权利，否则，用户应对其自身行为及对由此产生的任何后果承担全部法律责任。本平台仅为用户提供上传服务供用户分享内容，本平台对用户上传的内容不做任何修改或编辑，本平台坚决反对任何违反中华人民共和国法律法规的行为。\n" +
                    "\n" +
                    "7.7如您认为本平台中由用户上传的内容（包含文字、图片等形式）侵犯了您的合法权益，或用户上传的内容违反了相关的法律法规，请按照以下步骤和要求提交相关材料进行举报，以尽可能地维护互联网的绿色环境、保护您的合法权益。本平台将根据权利人提交的材料，遵循相关法律法规，在审查核实后尽快予以处理。点击“举报”按钮，并按照系统的提示填写相应的信息。包括但不限于以下内容：\n" +
                    "\n" +
                    "（1）权利人主体信息\n" +
                    "\n" +
                    "（2）权利人举报的侵权内容及要求：包括要求删除、断开链接的内容及其网页地址\n" +
                    "\n" +
                    "（3）权利人的权利证明材料：如著作权、商标权、专利权等知识产权侵权，则应提供包括但不限于著作权登记证书、商标证、专利证书、作品首次公开发表或发行日期证明材料、创作手稿、经权威机构签发的作品创作时间戳、作品备案证书等能有效证明权利人拥有相关权利的权属证明；如名誉权、隐私权等其他合法权益侵权，则应提供相应有效证明材料；以及对涉嫌侵权行为和侵权事实的具体列明。权利人应当保证：其在举报界面中提供的信息及其他相关材料是真实、合法、有效的。由于举报人提供的相关材料、文件引起的一切后果皆由举报人承担。举报人保证承担和赔偿因本平台根据举报人的通知而删除或者断开有关内容的链接而给本平台造成的任何损失，包括但不限于本平台因向被投诉或对用户赔偿而产生的损失及本平台名誉、商誉损害等。本平台在收到符合上述要求的举报信息后，将在合理时间内审查，审查无误后将删除涉嫌侵权的内容。如不符合上述条件，我们会将举报信息驳回并请您补充提供相应信息和材料，但暂时不会采取包括删除或者断开等相应措施。由于举报信息涉及的内容不同，复杂程度亦不同，故所需周期也不同，请您耐心等待。\n" +
                    "\n" +
                    "第八条 适用法律和争议解决\n" +
                    "8.1本协议的成立、生效、履行、解释及因本协议产生的任何争议，均适用中华人民共和国相关法律法规（不包括港澳台地区法律法规）。\n" +
                    "\n" +
                    "8.2用户和平台方之间与本协议有关的任何争议，首先应友好协商解决，在争议发生之日起三十日内仍不能通过协商达成一致的，用户同意将前述争议提交平台方所在地的人民法院进行诉讼。\n" +
                    "\n" +
                    "8.3如本协议中的任何条款因任何原因完全或部分无效或不具有执行力，均不影响本协议其他条款的效力。\n" +
                    "\n" +
                    "8.4本协议及本协议任何条款内容的最终解释权及修改权归平台方所有。\n" +
                    "\n"
        }else{
            tv.text = "自动订阅服务协议\n" +
                    "本服务协议（下称“协议”）是您（下称“用户”）与我们之间关于用户使用本产品（下称“本产品”或“本应用”）自动订阅功能所订立的协议。\n" +
                    "\n" +
                    "用户应认真阅读并充分理解此“软件使用及服务协议”。请审慎阅读并选择接受或不接受本“协议”（未成年人应在法定监护人陪同下阅读）。\n" +
                    "\n" +
                    "本“协议”可能随时更新，更新后的协议条款一经公布，即时代替原来的协议条款，用户可随时查阅最新版协议条款。在修改“协议”条款后，用户继续使用软件和服务，将被视为已接受了修改后的协议。如果用户不接受修改后的条款，请立即停止使用。\n" +
                    "\n" +
                    "一、服务说明\n" +
                    "1.1本服务是出于用户对于自动续费的需求，在用户已开通本服务的前提下，避免用户因疏忽或其他原因导致未能及时续费造成损失而推出的服务。用户不可撤销的授权本产品可在用户有效期即将过期时，从用户的自有充值账户，与用户账号绑定的第三方支付账户，银行卡，通信账户（以下统称“账户”）余额中代扣下一个计费周期包月费，该服务实现的前提是用户已将用户账号与上述账户绑定，且可成功从其上述账户中扣款。\n" +
                    "\n" +
                    "1.2自动订阅具体指，基于2.1的前提，本产品通过上述账户收取用户下一计费周期包月费的扣费方式，用户需保证可以从上述账户扣款成功，因上述账户中可扣款余额不足导致的续费失败，由用户自行承担责任。\n" +
                    "\n" +
                    "1.3用户在享受本服务时，应受“自动订阅服务协议”与“用户隐私协议”的约束，当用户使用本服务时，用户的使用行为视为其对本服务的服务条款以及紫薇命盘针对本服务发出的各类公示的同意。\n" +
                    "\n" +
                    "二、双方的权利和义务\n" +
                    "2.1本产品通过用户上述账户扣除下一订阅周期订阅费，应于上一订阅周期结束前24小时扣划，并将款项记入用户支付记录，并同时相应延长用户有效期。\n" +
                    "\n" +
                    "2.2如在扣费过程出现差错，本产品和用户应密切配合查因原因，各自承担己方过错造成的损失;若因双方各自存在不均等过错造成的损失，由双方按过错的程度承担相应责任;双方共负责任的，由双方均摊责任。\n" +
                    "\n" +
                    "2.3本产品可根据其业务开展或技术升级等情况变更或修改本协议的有关服务内容，规则及条款，本产品在做出上述变更或修改前，将在本产品相关页面上公示修改的内容，但无义务另行做个别通知如果用户不同意本协议的修改，可以取消已经获取的服务并停止使用;如果用户继续使用提供的服务，则视为用户已经接受本协议的全部修改。\n" +
                    "\n" +
                    "2.4本服务由用户自主选择是否取消，若用户选择不取消，则视为用户同意按照一定规则进行不定期的扣款尝试，一旦扣款成功，将为用户开通下一个计费周期的服务。\n" +
                    "\n" +
                    "2.5若在自动续费24时/之前，订阅服务价格发生调整，应以现时有效的价格为准。\n" +
                    "\n" +
                    "三、协议有效期限，终止\n" +
                    "3.1本协议自用户选择接受或使用本服务后生效，直至用户终止本服务或注销用户资格时终止。\n" +
                    "\n" +
                    "3.2用户有权随时在用户账号设置中选择终止本服务，终止后本服务后，将停止向用户提供本服务。\n" +
                    "\n" +
                    "3.3取消订阅步骤：\n" +
                    "手动打开iPhone或IPad“设置”→进入“iTunes Store与App Store”→点击“Apple ID”，选择“查看Apple ID”，进入“账户设置”页面，点击“订阅”，选择本产品，取消相应订阅即可。\n" +
                    "\n" +
                    "3.4用户在选择终止本服务前已经委托本产品自动续费扣款的指令仍然有效，本产品对于基于该指令扣除的费用不予退还，由用户承担相关责任。\n" +
                    "\n" +
                    "四、法律责任与免责申明\n" +
                    "4.1 本产品将会尽其商业上的合理努力以保护用户的设备资源及通讯的隐私性和完整性，但是，用户承认和同意本产品不能就此事提供任何保证。\n" +
                    "\n" +
                    "4.2 本产品可以根据用户的使用状态和行为，改进“本产品”的功能，用户体验和服务，开发或调整软件功能。\n" +
                    "\n" +
                    "4.3 遇到不可抗拒的市场下架行为，导致“本产品”不能继续付费，本产品及合作方不承担任何责任。\n" +
                    "\n" +
                    "4.4 在任何情况下因使用或不能使用本“本产品”所产生的直接，间接，偶然，特殊及后续的损害及风险，本产品及合作方不承担任何责任。\n" +
                    "\n" +
                    "4.5 因技术故障等不可抗事件影响到服务的正常运行的，本产品及合作方承诺在第时时间内与相关单位配合，及时处理进行修复，但用户因此而遭受的一切损失，本产品及合作方不承担责任。\n" +
                    "\n" +
                    "4.6 用户通过“本产品”与其他用户联系，因受误导或欺骗而导致或可能导致的任何心理，生理上的伤害以及经济上的损失，由过错方依法承担所有责任，一概与本产品及合作方无关。\n" +
                    "\n" +
                    "4.7 用户手动删除，或主动行为注销本产品帐号导致信息销毁的，本产品及合作方不承担任何责任。\n" +
                    "\n" +
                    "4.9 在本协议中未声明的其他一切权利，仍归本产品所有。本产品保留对本协议的最终解释权利。\n" +
                    "\n" +
                    "如果您还有其他问题和建议，可以通过电子邮件215351611@qq.com联系我们。"
        }
    }
}