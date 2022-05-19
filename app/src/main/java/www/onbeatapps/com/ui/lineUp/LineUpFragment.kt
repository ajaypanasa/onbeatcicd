package www.onbeatapps.com.ui.lineUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import www.onbeatapps.com.R
import www.onbeatapps.com.databinding.FragmentAccountBinding
import www.onbeatapps.com.databinding.FragmentLineUpBinding
import www.onbeatapps.com.databinding.SampleFragmentBinding
import www.onbeatapps.com.ui.base.BaseFragment
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity
import www.onbeatapps.com.ui.homeFragment.HomeAdapter

@AndroidEntryPoint
class LineUpFragment : BaseFragment<LineUpViewModel>() {
    private var _binding: FragmentLineUpBinding? = null
    private val binding get() = _binding!!
    private val lineUpViewModel: LineUpViewModel by viewModels()
    private var lineUpAdapter: LineUpAdapter? = null

    override fun setup() {
        DashBoardActivity.naviId =  R.id.navigation_line_up
        setUpRV()
        setUpClick()
    }

    private fun setUpClick() {
        binding.apply {
            btSideMenu.setOnClickListener {
                DashBoardActivity.clickEventSlide()
            }
        }
    }

    private fun setUpRV() {
        lineUpAdapter = LineUpAdapter(mContext){

            findNavController().navigate(R.id.navigation_artist_info)
        }
        binding.recyArtiest.apply {
            setHasFixedSize(true)
            adapter = lineUpAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        _binding = FragmentLineUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModel() = lineUpViewModel

}