package www.onbeatapps.com.ui.ticketScan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import www.onbeatapps.com.R
import www.onbeatapps.com.databinding.FragmentLostBandBinding
import www.onbeatapps.com.databinding.FragmentTicketTempleatBinding
import www.onbeatapps.com.databinding.FragmentUnlinkTicketBinding
import www.onbeatapps.com.ui.account.AccountViewModel
import www.onbeatapps.com.ui.base.BaseFragment

@AndroidEntryPoint
class UnlinkTicketFragment : BaseFragment<AccountViewModel>() {
    private var _binding: FragmentTicketTempleatBinding? = null
    private val binding get() = _binding!!
    private val accountViewModel: AccountViewModel by viewModels()

    override fun setup() {

        setUpClick()
        setUi()

    }
    private fun setUi() {
        binding.apply {
            btBack.visibility = View.GONE
            txtDoLater.visibility = View.VISIBLE
            toopBar.text = getString(R.string.unlink_ticket1)
            txtContent.text = getString(R.string.no_loger_attend)
            txtDoLater.text = getString(R.string.unlink_note)
            icon.setImageResource(R.drawable.ic_unlink)
        }
    }


    private fun setUpClick() {
        binding.apply {
            btBack.setOnClickListener {
                findNavController().popBackStack()
            }
            btYes.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_unlink_to_navigation_unlink_confirm)
            }
            btNo.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        _binding = FragmentTicketTempleatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModel() = accountViewModel

}