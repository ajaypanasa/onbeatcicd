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
import www.onbeatapps.com.databinding.FragmentUnlinkTicketConfirmBinding
import www.onbeatapps.com.ui.account.AccountViewModel
import www.onbeatapps.com.ui.base.BaseFragment
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity

@AndroidEntryPoint
class UnlinkTicketConfirmFragment : BaseFragment<AccountViewModel>() {
    private var _binding: FragmentTicketTempleatBinding? = null
    private val binding get() = _binding!!
    private val accountViewModel: AccountViewModel by viewModels()

    override fun setup() {

        setUpClick()
        setUi()
        setUpObservet()

    }

    private fun setUi() {
       binding.apply {
           btBack.visibility = View.VISIBLE
           txtDoLater.visibility = View.GONE
           toopBar.text = getString(R.string.are_you)
           txtContent.text = getString(R.string.un_link_clear_data)
           icon.setImageResource(R.drawable.ic_sure)
       }
    }

    private fun setUpObservet() {
        accountViewModel.unlinkStatus.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.action_navigation_unlink_confirm_to_navigation_unlink_success)
                accountViewModel.unlinkStatus.value = false
            }
        }
        accountViewModel.userDtCall.observe(viewLifecycleOwner){
            if (it){
                accountViewModel.unlinkTicket()
                accountViewModel.userDtCall.value = false
            }
        }
        accountViewModel.settilCall.observe(viewLifecycleOwner) {
            if (it) {
                accountViewModel.settle(accountViewModel.callType)
                accountViewModel.settilCall.value = false
            }
        }
        accountViewModel.deleteCall.observe(viewLifecycleOwner) {
            if (it) {
                accountViewModel.unlinkTicket()
                accountViewModel.deleteCall.value = false
            }
        }
    }


    private fun setUpClick() {
        binding.apply {

            btBack.setOnClickListener {
                findNavController().popBackStack()
            }
            btYes.setOnClickListener {

                if (!accountViewModel.getCardStatus())
                    accountViewModel.unlinkTicket()
                else accountViewModel.settle(1)
            }
            btNo.setOnClickListener {
                findNavController().navigate(R.id.nav_account)
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